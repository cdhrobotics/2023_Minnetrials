// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// ARM SUBSYSTEM

public class LumpySubsystem extends SubsystemBase {
  
  public final CANSparkMax armMotor = new CANSparkMax(5, MotorType.kBrushless);
  public final RelativeEncoder armEncoder = armMotor.getEncoder();
  
  public LumpySubsystem() {
   
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */

   public void ManualInputs(XboxController xbox) {
    if ((xbox.getLeftX() < .15) && (xbox.getLeftX() > -0.15)) {
      armMotor.set(0);
    }
    else {
      armMotor.set(xbox.getLeftX() / 5);

    }

  }





  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Encoder: ", armEncoder.getPosition());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
