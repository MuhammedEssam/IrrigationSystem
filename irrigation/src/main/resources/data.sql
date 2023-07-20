
insert into plots (ID, NAME, AREA, CROP,WATERQUANTITY) VALUES
  (1,'kanater', 6, 'rise',50),
  (2,'ismalia', 2, 'mango',10),
  (3,'sodan', 60, 'tomato',40);

insert into sensors (ID,NAME, STARTTIME, ENDTIME,RUNNING,ISCOMPLETED,Plot_ID) VALUES
  (1,'sensor_1', '11:00:01', '12:56:01',FALSE,FALSE,1),
  (2,'sensor_2', '22:56:01', '08:56:01',FALSE,FALSE,2),
  (3,'sensor_3', '11:00:01', '12:56:01',FALSE,FALSE,2),
  (4,'sensor_4', '20:32:01', '23:56:01',FALSE,FALSE,1),
  (5,'sensor_5', '22:56:01', '23:56:01',FALSE,FALSE,3);