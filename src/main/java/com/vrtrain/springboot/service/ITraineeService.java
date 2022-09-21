package com.vrtrain.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vrtrain.springboot.controller.dto.TraineeDTO;
import com.vrtrain.springboot.entity.Trainee;

public interface ITraineeService extends IService<Trainee> {
    TraineeDTO login(TraineeDTO traineeDTO);

    Trainee register(Trainee trainee);
}
