CREATE INDEX event_creatorid ON public.event(creatorid);
CREATE INDEX message_eventid ON public.message(eventid);
CREATE INDEX message_senderid ON public.message(senderid);
CREATE INDEX message_recipientid ON public.message(recipientid);
CREATE INDEX participation_userid ON public.participation(userid);
CREATE INDEX participation_eventid ON public.participation(eventid);

CREATE INDEX event_date ON public.event(date);
CREATE INDEX event_eventname ON public.event(eventname);
CREATE INDEX event_occasion ON public.event(occasion);
CREATE INDEX event_location ON public.event(location);
CREATE INDEX event_lon ON public.event(lon);
CREATE INDEX event_lat ON public.event(lat);
CREATE INDEX event_numbermaleconfirmed ON public.event(numbermaleconfirmed);
CREATE INDEX event_numberfemaleconfirmed ON public.event(numberfemaleconfirmed);

CREATE INDEX message_textmessage ON public.message(textmessage);
CREATE INDEX message_date ON public.message(date);

CREATE INDEX user_name ON public.user(name);
CREATE INDEX user_email ON public.user(email);
CREATE INDEX user_gender ON public.user(gender);
CREATE INDEX user_birthday ON public.user(birthday);
