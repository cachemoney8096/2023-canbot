package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class DriveTrain extends SubsystemBase {


// identifying the type of motor and giving each on a number that is defined somewhere else
    private static VictorSPX motorLeft1 = new VictorSPX(RobotMap.DRIVE_LEFT_MOTOR_1_ID);
    private static VictorSPX motorLeft2 = new VictorSPX(RobotMap.DRIVE_LEFT_MOTOR_2_ID);
    private static VictorSPX motorRight1 = new VictorSPX(RobotMap.DRIVE_RIGHT_MOTOR_1_ID);
    private static VictorSPX motorRight2 = new VictorSPX(RobotMap.DRIVE_RIGHT_MOTOR_2_ID);

    // double means the same thing as float in python
    // setting how the speed should be interpreted the left ones are negative because they are backwards in the physical robot
    public void setLeftMotors(double speed) {
        motorLeft1.set(ControlMode.PercentOutput, -speed);
        motorLeft2.set(ControlMode.PercentOutput, -speed);
    }

    public void setRightMotors(double speed) {
        motorRight1.set(ControlMode.PercentOutput, speed);
        motorRight2.set(ControlMode.PercentOutput, speed);
    }
    // makes wheels spin using methods above
    public void move(double left, double right){
        setLeftMotors(left);
        setRightMotors(right);
    }
}
