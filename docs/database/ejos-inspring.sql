--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.5
-- Dumped by pg_dump version 9.6.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: achievement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE achievement (
    id integer NOT NULL,
    question_id integer,
    student_id integer,
    score real,
    answercode character varying(10000),
    result character(1024),
    filepath character varying(256),
    version bigint
);


ALTER TABLE achievement OWNER TO postgres;

--
-- Name: question; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE question (
    id integer NOT NULL,
    name character varying(128),
    team_id integer,
    detail character varying(1024),
    deadtime timestamp without time zone,
    diffculty real,
    result character(1024),
    answercode character varying(10000),
    answerdetail character varying(1024)
);


ALTER TABLE question OWNER TO postgres;

--
-- Name: team; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE team (
    id integer NOT NULL,
    name character varying(32),
    introduce character(1024),
    teacher_id integer
);


ALTER TABLE team OWNER TO postgres;

--
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "user" (
    id integer NOT NULL,
    number character varying(20),
    password character varying(32),
    identity character varying(16),
    name character varying(32),
    idcard character varying(32),
    team_id integer,
    email character varying(64)
);


ALTER TABLE "user" OWNER TO postgres;

--
-- Data for Name: achievement; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY achievement (id, question_id, student_id, score, answercode, result, filepath, version) FROM stdin;
1	1	1	5	public class...	a=1                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             	\\data\\1\\1\\Student.java	1
\.


--
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY question (id, name, team_id, detail, deadtime, diffculty, result, answercode, answerdetail) FROM stdin;
1	类的声明	1	声明一个学生类Student,声明两个私有属性name,age	2018-06-07 14:00:02	99	a=0                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             	public class Student{\npriate String name;\nprivate int age;\n}	思路：先声明类，再声明属性
\.


--
-- Data for Name: team; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY team (id, name, introduce, teacher_id) FROM stdin;
1	电科本15	电科本15级三个班                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       	2
\.


--
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "user" (id, number, password, identity, name, idcard, team_id, email) FROM stdin;
3	admin	admin	admin	administritor	37010123456219651X	\N	admin@qq.com
1	15110471070	123456	student	gaoyisheng	37010519970219651X	1	1160139211@qq.com
2	120110	123456	teacher	kongfuzi	37010518000219651X	\N	654321@qq.com
4	123456	123456	teacher	test_tescher	37010123456219651X	\N	123456@qq.com
5	15110471069	123456	student	huanlu	37010519970219651X	1	118946461@qq.com
6	15110471068	123456	student	张飞	37010504663215619X	1	zhangfei@qq.com
7	admin2	admin	admin	administritor2	37010599999919651X	\N	administritor@123.com
\.


--
-- Name: achievement achievement_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY achievement
    ADD CONSTRAINT achievement_pkey PRIMARY KEY (id);


--
-- Name: question question_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY question
    ADD CONSTRAINT question_pkey PRIMARY KEY (id);


--
-- Name: team team_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY team
    ADD CONSTRAINT team_pkey PRIMARY KEY (id);


--
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- Name: fki_question_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_question_id ON achievement USING btree (question_id);


--
-- Name: fki_student_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_student_id ON achievement USING btree (student_id);


--
-- Name: fki_teacher_user; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_teacher_user ON team USING btree (teacher_id);


--
-- Name: fki_team_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_team_id ON question USING btree (team_id);


--
-- Name: fki_user-team; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX "fki_user-team" ON "user" USING btree (team_id);


--
-- Name: achievement question_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY achievement
    ADD CONSTRAINT question_id FOREIGN KEY (question_id) REFERENCES question(id);


--
-- Name: achievement student_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY achievement
    ADD CONSTRAINT student_id FOREIGN KEY (student_id) REFERENCES "user"(id);


--
-- Name: user student_team; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT student_team FOREIGN KEY (team_id) REFERENCES team(id);


--
-- Name: team teacher_user; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY team
    ADD CONSTRAINT teacher_user FOREIGN KEY (teacher_id) REFERENCES "user"(id);


--
-- Name: question team_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY question
    ADD CONSTRAINT team_id FOREIGN KEY (team_id) REFERENCES team(id);


--
-- PostgreSQL database dump complete
--

