// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.Constants;
import frc.robot.RobotMap;

public class Crusher extends SubsystemBase {

  private static VictorSPX motor = new VictorSPX(RobotMap.CRUSHER_MOTOR_ID);

  public static void crush() {
    motor.set(ControlMode.PercentOutput, Constants.CRUSHER_POWER);
  }

  public static void uncrush() {
    motor.set(ControlMode.PercentOutput, -Constants.CRUSHER_POWER);
  }

  public static void holdCrush() {
    motor.set(ControlMode.PercentOutput, 0);
  }

}
