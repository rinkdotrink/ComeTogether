Select e.numberFemaleConfirmed, Count(m.messageid) as anzahlMessages
from public.user u, public.event e, public.participation p, public.message m
where u.gender = 'w'
AND u.birthday between '01.01.1986' AND '31.12.1992'
AND e.date between '01.01.2013' AND '01.03.2013'
AND m.date between '01.01.2010' AND '31.12.2012'
AND m.textmessage like '%Salsa'
AND e.eventid = p.eventid
AND p.userid = u.userid
AND m.senderId = u.userId
AND e.numberMaleConfirmed / e.numberFemaleConfirmed < 0.5
AND e.numberFemaleConfirmed > 30
AND DEGREES(acos(cos(RADIANS(90-e.lat))*cos(RADIANS(90-70))+sin(RADIANS(90-e.lat))*
sin(RADIANS(90-70))*cos(RADIANS(e.lon-80))))/360*40074 < 10000
AND m.recipientId in
(Select u2.userId
from public.user u2
where u2.gender = 'm'
AND u2.birthday between '01.01.1972' AND '31.12.1982'
)
Group by e.numberFemaleConfirmed
Order by e.numberFemaleConfirmed DESC