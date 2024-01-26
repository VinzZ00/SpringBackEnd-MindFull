-- This script was generated by the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.


-- recreate database
BEGIN;
drop database if exists mindfull;
CREATE database IF NOT EXISTS  mindfull;
use mindfull;
END;

-- recreate table
BEGIN;
CREATE TABLE IF NOT EXISTS public.goals
(
    goalid int,
    Name text,
    goalIndicator text,
    timeBound date,
    date_created timestamp,
    reason text,
    CONSTRAINT goals_pkey PRIMARY KEY (goalid)
);

CREATE TABLE IF NOT EXISTS public.steps
(
    stepId int,
    daily_time time,
    goalid int,
    CONSTRAINT steps_pkey PRIMARY KEY (stepid, goalid)
);

ALTER TABLE IF EXISTS public.steps
    ADD CONSTRAINT steps_goalid_fkey FOREIGN KEY (goalid)
        REFERENCES public.goals (goalid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION;

END;