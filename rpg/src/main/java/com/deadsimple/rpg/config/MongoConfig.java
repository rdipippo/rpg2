package com.deadsimple.rpg.config;

import com.github.mongobee.Mongobee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {
    @Bean
    public Mongobee mongobee(){
        Mongobee runner = new Mongobee("mongodb://rdipippo:magius18@ds247170.mlab.com:47170/heroku_94gg2nzx");
        runner.setChangeLogsScanPackage("com.deadsimple.rpg.model.changelogs");

        return runner;
    }
}
