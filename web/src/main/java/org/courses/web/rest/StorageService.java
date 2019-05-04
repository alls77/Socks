package org.courses.web.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.courses.data.DAO.DAO;
import org.courses.domain.hbm.Storage;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.Collection;

@RestController
@RequestMapping("/test")
public class StorageService {

    DAO<Storage,Integer> storageDao;

    public StorageService(DAO<Storage, Integer> storageDao) {
        this.storageDao = storageDao;
    }

    @RequestMapping(value = "/storage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<String> getStorage() throws JsonProcessingException {

        Collection<Storage> storage = storageDao.readAll();
        Collection<String> js = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();

        for (Storage st: storage) {
            String json = mapper.writeValueAsString(st);
            js.add(json);
        }

        return js;
    }
}
