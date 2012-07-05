ALTER TABLE public.event ADD PRIMARY KEY (eventid);
ALTER TABLE public.message ADD PRIMARY KEY (messageid);
ALTER TABLE public.participation ADD PRIMARY KEY (participationid);
ALTER TABLE public.user ADD PRIMARY KEY (userid);

ALTER TABLE event ADD CONSTRAINT event_creatorid FOREIGN KEY (creatorid) REFERENCES public.user (userid) MATCH FULL;
ALTER TABLE message ADD CONSTRAINT message_eventid FOREIGN KEY (eventid) REFERENCES event (eventid) MATCH FULL;
ALTER TABLE message ADD CONSTRAINT message_senderid FOREIGN KEY (senderid) REFERENCES public.user (userid) MATCH FULL;
ALTER TABLE message ADD CONSTRAINT message_recipientid FOREIGN KEY (recipientid) REFERENCES public.user (userid) MATCH FULL;
ALTER TABLE participation ADD CONSTRAINT participation_userid FOREIGN KEY (userid) REFERENCES public.user (userid) MATCH FULL;
ALTER TABLE participation ADD CONSTRAINT participation_eventid FOREIGN KEY (eventid) REFERENCES event (eventid) MATCH FULL;

