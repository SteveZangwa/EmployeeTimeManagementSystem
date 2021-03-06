package com.adp3.repository.standalone.impl;

import com.adp3.entity.standalone.TimekeepingService;
import com.adp3.repository.standalone.TimekeepingServiceRepository;

import java.util.*;

class TimekeepingServiceRepositoryImpl implements TimekeepingServiceRepository {
    private static TimekeepingServiceRepositoryImpl repository =null;
    private Map<String,TimekeepingService> TimekeepingService;
    private TimekeepingServiceRepositoryImpl()
    {
    this.TimekeepingService = new HashMap<>();}

    public static TimekeepingServiceRepository getRepository() {
        if(repository==null)repository=new TimekeepingServiceRepositoryImpl();
        return repository;
    }

    @Override
    public Set<TimekeepingService> getAll() {
        Collection<TimekeepingService> timekeepingServices =this.TimekeepingService.values();
        Set<TimekeepingService> set =new HashSet<>();
        set.addAll(timekeepingServices);
        return set;

    }

    @Override
    public TimekeepingService create(TimekeepingService TimekeepingService) {
        this.TimekeepingService.put(TimekeepingService.getempID(),TimekeepingService);

        return TimekeepingService;
    }

    @Override
    public TimekeepingService read(String TimekeepingServiceID) {
        return this.TimekeepingService.get(TimekeepingServiceID);
    }

    public TimekeepingService update(TimekeepingService TimekeepingServiceIn) {
//        this.TimekeepingService.replace(TimekeepingServiceIn.getempID(),TimekeepingServiceIn);
//
//        return this.TimekeepingService.get(TimekeepingServiceIn.getempID());


        if(this.read(TimekeepingServiceIn.getempID())==null){
            this.delete(TimekeepingServiceIn.getempID());
            this.create(TimekeepingServiceIn);
        };

        return TimekeepingServiceIn;
    }

    @Override
    public void delete(String s) {
        this.TimekeepingService.remove(s);
    }
}
