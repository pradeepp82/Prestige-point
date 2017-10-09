alter table `aartek14_prestigepoint_db`.`currentbatch` 
   add column `BATCH_NAME` varchar(60) NULL after `CURRENT_TOPIC`,
   change `BATCH_ID` `BATCH_ID` int(60) NULL 