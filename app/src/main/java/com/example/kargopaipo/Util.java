package com.example.kargopaipo;

import com.example.kargopaipo.model.Job;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Kanish Roshan on 2020-02-17.
 */
public class Util
{

    public  static List<Job> sortFunction(List<Job> jobList){
        Collections.sort(jobList, new Comparator<Job>() {
            @Override
            public int compare(Job job, Job t1) {
                return  job.getCost().compareTo(t1.getCost());
            }

        });
      return jobList;
    }
}
