alter table `aartek14_prestigepoint_db`.`enquiry` 
   add column `QUALIFICATION` varchar(60) NULL after `SUBJECT`, 
    add column `ENQUIRY_BY` varchar(60) NULL after `QUALIFICATION`, 
    add column `LAST_NAME` varchar(60) NULL after `ENQUIRY_BY`, 
   add column `COLLAGE` varchar(60) NULL after `LAST_NAME`, 
   add column `REFERENCE_NAME` varchar(60) NULL after `COLLAGE`, 
   add column `REFERENCER_MOBILE_NO` varchar(60) NULL after `REFERENCE_NAME`, 
   add column `TRAINING_TYPE` varchar(60) NULL after `REFERENCER_MOBILE_NO`, 
   add column `HANDLED_BY` varchar(60) NULL after `TRAINING_TYPE`
   
   
   alter table `aartek14_prestigepoint_db`.`enquiry` 
   add column `Response` int(10) NULL after `HANDLED_BY`,
   add column `status` int(10) NULL after `Response`
   