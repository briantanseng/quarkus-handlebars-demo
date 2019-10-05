package com.a98labs.demos.quarkus.handlebars;


import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.a98labs.demos.quarkus.handlebars.dto.ApplicationInfoDto;
import com.a98labs.demos.quarkus.handlebars.dto.LinkDto;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.FileTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;

@ApplicationScoped
public class TemplateService {

    @ConfigProperty(name = "template.path")
    String templatePath;
    
    public String processHandlebarsTemplate() {
        String result = "Uh oh! The template didn't work.";
        System.out.println("Template path: "+templatePath);
        
        TemplateLoader loader = new FileTemplateLoader(templatePath);
        loader.setSuffix(".html");
        Handlebars handlebars = new Handlebars(loader);
        Template template = null;
        
        try {
            template = handlebars.compile("greeting");
            
            Map<String, Object> parameterMap = new HashMap<>();
            parameterMap.put("message", getRandomMessage());
            parameterMap.put("color", getRandomColor());
            parameterMap.put("today", getDate());
            parameterMap.put("links", getLinks());
            parameterMap.put("app", getApplicationInfo());
            
            result = template.apply(parameterMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return result;
        
    }
    
    private String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy hh:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }
    
    private String getRandomMessage() {
        String[] messages = { "Hello, wonderful world!", 
                "Hey! Hey! Hey!", "Whoa!", "Boom! Boom! Pow!", 
                "Ba-da-bing!", "Rock en roll!", "Hi, beautiful!" };
        
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(messages.length);
        
        System.out.println("Message chosen: "+messages[randomInt]);
        return messages[randomInt];
    }
    
    private String getRandomColor() {
        String[] colors = { "#00A1E2;", "#0E6655;", "#DC7633;", "#2E86C1;", "#CB4335;", "#5D6D7E;" };
        
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(colors.length);
        
        System.out.println("Color chosen: "+colors[randomInt]);
        return colors[randomInt];
    }
    
    private List<LinkDto> getLinks() {
        ArrayList<LinkDto> links = new ArrayList<LinkDto>();
        
        links.add(new LinkDto("freemarker", "https://freemarker.apache.org/"));
        links.add(new LinkDto("velocity", "https://velocity.apache.org/"));
        links.add(new LinkDto("Handlebars.java", "http://jknack.github.io/handlebars.java/"));
        links.add(new LinkDto("mustache.java", "https://github.com/spullara/mustache.java"));
        links.add(new LinkDto("thymeleaf", "https://www.thymeleaf.org"));
        
        return links;
    }
    
    private ApplicationInfoDto getApplicationInfo() {
        return new ApplicationInfoDto();
    }
    
    
}
