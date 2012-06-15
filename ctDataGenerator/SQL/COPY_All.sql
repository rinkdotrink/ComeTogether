COPY public.Event (eventid, creatorid, date, eventname, occasion, location, lonRad, latRad, description, numbermaleconfirmed, numberfemaleconfirmed) From 'C:\Event.txt' DELIMITER ';';
COPY public.Message (messageid, eventid, senderid, recipientid, textmessage, date) From 'C:\Message.txt' DELIMITER ';';
COPY public.Participation (participationid, userid, eventid) From 'C:\Participation.txt' DELIMITER ';';
COPY public.User (userId, name, email, gender, birthday, password, image) From 'C:\User.txt' DELIMITER ';';
