// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.GenericHID;
import frc.robot.subsystems.Crusher;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.libs.XboxController;

import frc.robot.subsystems.DriveTrain;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final XboxController controller;

  private final DriveTrain drivetrain;
  private final Crusher crusher;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    controller = new XboxController(RobotMap.DRIVER_CONTROLLER_INDEX);
    drivetrain = new DriveTrain();
    crusher  = new Crusher();

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    controller
      .BumperRight()
      .whileHeld(
        new InstantCommand(crusher::crush, crusher).withName("Crushing"));
    
    crusher.setDefaultCommand(new InstantCommand(crusher::uncrush, crusher));

    // drive controls
    drivetrain.setDefaultCommand(
        new RunCommand(
                () ->
                    drivetrain.move(
                        MathUtil.applyDeadband(controller.getLeftY() + controller.getRightX(), 0.1),
                        MathUtil.applyDeadband(controller.getLeftY() - controller.getRightX(), 0.1)),
                drivetrain)
            .withName("Manual Drive"));
  }
}
