package com.crio.codingame.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.crio.codingame.entities.Contest;
import com.crio.codingame.entities.Level;

public class ContestRepository implements IContestRepository {

    private final Map<String,Contest> contestMap;
    private Integer autoIncrement = 0;


    public ContestRepository() {
        contestMap = new HashMap<String,Contest>();
    }

    public ContestRepository(Map<String, Contest> contestMap) {
        this.contestMap = contestMap;
        this.autoIncrement = contestMap.size();
    }

    @Override
    public Contest save(Contest entity) {
        if( entity.getId() == null ){
            autoIncrement++;
            Contest c = new Contest(Integer.toString(autoIncrement),entity.getName(),entity.getQuestions(),entity.getLevel(),entity.getCreator(),entity.getContestStatus());
            contestMap.put(c.getId(),c);
            return c;
        }
        contestMap.put(entity.getId(),entity);
        return entity;
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Find all the list of Contest Present in the Repository
    // Tip:- Use Java Streams

    @Override
    public List<Contest> findAll() {
      List<Contest> obj=new ArrayList<>();
    for (Map.Entry<String,Contest> entry : contestMap.entrySet()) 
            {
                obj.add(entry.getValue());
            }
    return obj;
    }

    @Override
    public Optional<Contest> findById(String id) {
        return Optional.ofNullable(contestMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void delete(Contest entity) {
        // TODO Auto-generated method stub
        
    }
    // public Contest getcontest(String id){
    //        return contestMap.get(id);
    // }
    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        contestMap.remove(id);
        
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Find all the list of Contest Present in the Repository provided Level
    // Tip:- Use Java Streams

    @Override
    public List<Contest> findAllContestLevelWise(Level level) {
        if(level==null) return findAll();
        List<Contest> obj=new ArrayList<>();
        for(Contest x: findAll()){
            if(x.getLevel()==level){
                 obj.add(x);
            }
        }
        return obj;
    }

    @Override
    public Contest getcontest(String contestId) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
