package com.alex.javacamp.repository;

import com.alex.javacamp.domain.Teacher;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TeacherRepository {
    private static ConcurrentHashMap<Integer, Teacher> storage = new ConcurrentHashMap<>();

    static {
        storage.put(3, Teacher.builder()
               // .classes(Collections.singleton("matematica"))
                .name("Ionescu")
                .id(3)
                .collegeId(1)
                .build());
        storage.put(4, Teacher.builder()
                //.classes(Collections.singleton("fizica"))
                .name("Popescu")
                .id(4)
                .collegeId(2)
                .build());

    }

    public List<Teacher> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<Teacher> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    public Teacher save(Teacher teacher) {
        teacher.setId(teacher.hashCode());
        return storage.put(teacher.hashCode(), teacher);

    }
}
