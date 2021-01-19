package com.fly.server.test.service.impl;

import com.fly.server.test.entity.Student;
import com.fly.server.test.mapper.StudentMapper;
import com.fly.server.test.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fly
 * @since 2021-01-19
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
