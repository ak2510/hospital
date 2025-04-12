package com.ajay.hospital.service;

import org.springframework.stereotype.Service;

@Service
public class ElasticService {

    private String elasticUrl;

    private String elasticUsername;

    private String elasticPassword;

    private static final int MAX_ELASTIC_TRIES = 5;

}
