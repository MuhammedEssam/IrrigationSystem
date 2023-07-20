# IrrigationSystem
this is a simple automatic irrigation system


# Plot Module
The Plot Module of the Sensor Management System is a Java-based application that allows users to manage and track plots used in agricultural settings. This module provides functionalities to add, update, and delete plots, along with their associated sensors.

## Entity
The PlotEntity class represents the entity for plots and their attributes. Each plot can have multiple associated sensors using a One-to-Many relationship.

## Service
The PlotService class provides functionalities to interact with the plot data and repository.

## Controller
The PlotController class provides REST API endpoints for managing plots and their associated sensors.

## Features
Add new plots to the database.
Update plot information, such as area, crop, and water quantity.
Associate sensors with plots using a One-to-Many relationship.
Retrieve all plots along with their associated sensors.



# Sensor Module

## Entity
The SensorEntity class represents the entity for sensors and their attributes. Each sensor is associated with a plot using a Many-to-One relationship.

## Service
The sensorService class provides functionalities to interact with the sensor data and repository.

## Controller
The sensorController class provides REST API endpoints for managing sensors and their association with plots.

## Features
Add new sensors to the database.
Associate sensors with their respective plots.
Retrieve sensor data based on sensor names.
Update sensor information.

# Irrigation Service
The irrigateService class is a Spring service that provides functionalities related to irrigation management. It includes methods to control the irrigation process, update sensor status, associate sensors with plots, and reset sensors daily.

## Scheduled Irrigation
The irrigate() method is scheduled to run every 60 seconds (fixedDelay = 60000). It checks the status of all sensors and manages their irrigation process. If a sensor's start time matches the current time (ignoring seconds) and the sensor is not already running, it initiates irrigation for that sensor. Similarly, if a sensor's end time (ignoring seconds) is before the current time, it marks the sensor as completed.

## irrigateIsRunning() Method
The irrigateIsRunning(SensorEntity sensor) method is a private helper method used to simulate the irrigation process for a particular sensor. It prints a message indicating that the sensor is currently irrigating the associated plot.

## Sensor-to-Plot Association
The sensorToPlot(String plotName, String sensorName) method associates a sensor with a plot. It takes the names of the plot and sensor as parameters, retrieves their corresponding entities from the repositories, and then links the sensor to the plot. The updated sensor entity is then saved in the database.

## Daily Sensor Reset
The resetSensors() method is scheduled to run every 24 hours (fixedRate = 24 * 60 * 60 * 1000). It resets all sensor completion statuses, setting them to false. This daily reset ensures that sensors are ready for the next day's irrigation process.

## Note
Please make sure to adjust the scheduled intervals and timing according to your specific requirements and preferences.

## Usage
The irrigate() method is automatically triggered every 60 seconds to manage the irrigation process for sensors.
Use the sensorToPlot() method to associate a sensor with a specific plot.
The resetSensors() method resets the completion status of all sensors every 24 hours.

