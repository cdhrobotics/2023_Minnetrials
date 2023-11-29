// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveySubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.LumpySubsystem;

import org.ejml.dense.block.MatrixOps_MT_DDRB;

import edu.wpi.first.wpilibj2.command.CommandBase;



public class ShmooveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveySubsystem robot;
  private Double startingDistance = 0.0;
  private Double m_driveyDistance = 0.0;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ShmooveCommand(DriveySubsystem subsystem, Double driveyDistance) {
    robot = subsystem;
    m_driveyDistance = driveyDistance;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startingDistance = robot.legEncoder.getPosition();
    robot.fullSendYeetGo();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    robot.itsJoever();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double legPosition = robot.legEncoder.getPosition();

    if (legPosition < (m_driveyDistance + startingDistance)) {
      return false;
    } else {
      return true;
    }
  }
}
