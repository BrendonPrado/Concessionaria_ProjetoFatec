package com.fatec.ite.Concessionaria.configuration;

import com.fatec.ite.Concessionaria.utils.IniDataDev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javassist.tools.rmi.ObjectNotFoundException;

@Configuration
@Profile("dev")
public class DevConfiguration {

    @Autowired
    private IniDataDev iniDataDev;

    @Bean
    public boolean instantiateDatabase() throws ObjectNotFoundException {
        iniDataDev.initializeDataDev();
        return true;
    }

}
