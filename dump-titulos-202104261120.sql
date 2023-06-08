-- MySQL dump 10.13  Distrib 5.7.24, for Win64 (x86_64)
--
-- Host: localhost    Database: titulos
-- ------------------------------------------------------
-- Server version	5.7.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `autorizacionreconocimiento`
--

DROP TABLE IF EXISTS `autorizacionreconocimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autorizacionreconocimiento` (
  `id_autorizacion_reconocimiento` int(11) NOT NULL AUTO_INCREMENT,
  `autorización_reconocimiento` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_autorizacion_reconocimiento`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autorizacionreconocimiento`
--

LOCK TABLES `autorizacionreconocimiento` WRITE;
/*!40000 ALTER TABLE `autorizacionreconocimiento` DISABLE KEYS */;
INSERT INTO `autorizacionreconocimiento` VALUES (1,'RVOE FEDERAL'),(2,'RVOE ESTATAL'),(3,'AUTORIZACIÓN FEDERAL'),(4,'AUTORIZACIÓN ESTATAL'),(5,'ACTA DE SESIÓN'),(6,'ACUERDO DE INCORPORACIÓN'),(7,'ACUERDO SECRETARIAL SEP'),(8,'DECRETO DE CREACIÓN'),(9,'OTRO'),(10,'po rmis H. h'),(14,'jjjj');
/*!40000 ALTER TABLE `autorizacionreconocimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargo` (
  `id_cargo` int(11) NOT NULL AUTO_INCREMENT,
  `cargo_firmante` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_cargo`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (1,'DIRECTOR'),(2,'SUBDIRECTOR'),(3,'RECTOR'),(4,'VICERRECTOR'),(5,'RESPONSABLE DE EXPEDICIÓN '),(6,'SECRETARIO GENERAL'),(7,'AUTORIDAD LOCAL'),(8,'AUTORIDAD FEDERAL'),(9,'DIRECTOR GENERAL'),(10,'RECTOR GENERAL'),(11,NULL),(13,'sr verch'),(14,NULL);
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrera`
--

DROP TABLE IF EXISTS `carrera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrera` (
  `cve_carrera` int(11) NOT NULL,
  `nombre_carrera` varchar(100) DEFAULT NULL,
  `nivel_educativo` varchar(30) DEFAULT NULL,
  `rvoe_dgp` int(11) DEFAULT NULL,
  `tipo_rvoe` varchar(100) DEFAULT NULL,
  `id_entidad_federativa_rvoe` int(11) DEFAULT NULL,
  `sostenimiento` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cve_carrera`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrera`
--

LOCK TABLES `carrera` WRITE;
/*!40000 ALTER TABLE `carrera` DISABLE KEYS */;
INSERT INTO `carrera` VALUES (128528,'MAESTRÍA EN CIENCIAS EN INNOVACIÓN BIOTECNOLÓGICA','MAESTRÍA',NULL,NULL,NULL,'FEDERAL'),(320577,'MAESTRÍA EN CIENCIAS DE LA FLORICULTURA','MAESTRÍA',NULL,NULL,NULL,'FEDERAL'),(411598,'MAESTRÍA EN INVESTIGACIÓN CLÍNICA','MAESTRÍA',NULL,NULL,NULL,'FEDERAL'),(644621,'DOCTORADO EN CIENCIAS EN INNOVACIÓN BIOTECNOLÓGICA','DOCTORADO',NULL,NULL,NULL,'FEDERAL');
/*!40000 ALTER TABLE `carrera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datorecibo`
--

DROP TABLE IF EXISTS `datorecibo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datorecibo` (
  `iddatorecibo` int(11) NOT NULL AUTO_INCREMENT,
  `idhistoricorecibo` int(11) NOT NULL,
  `archivo` varchar(100) DEFAULT NULL,
  `estatus` int(11) DEFAULT NULL,
  `folio` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`iddatorecibo`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datorecibo`
--

LOCK TABLES `datorecibo` WRITE;
/*!40000 ALTER TABLE `datorecibo` DISABLE KEYS */;
INSERT INTO `datorecibo` VALUES (35,37,'XML 1',1,'CBGE17028750'),(36,37,'XML 1',2,'CBGE17028751'),(37,38,'XML 1',1,'CBGE17028750'),(38,38,'XML 1',2,'CBGE17028751'),(39,39,'XML 1',1,'CBGE17028750'),(40,39,'XML 1',2,'CBGE17028751'),(41,40,'XML 1',1,'CBGE17028750'),(42,40,'XML 1',2,'CBGE17028751');
/*!40000 ALTER TABLE `datorecibo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entidadfederativa`
--

DROP TABLE IF EXISTS `entidadfederativa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entidadfederativa` (
  `identidadfederativa` int(11) NOT NULL AUTO_INCREMENT,
  `ID_ENTIDAD FEDERATIVA` int(11) NOT NULL,
  `c_nom_ent` varchar(40) DEFAULT NULL,
  `c_entidad_abr` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`identidadfederativa`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entidadfederativa`
--

LOCK TABLES `entidadfederativa` WRITE;
/*!40000 ALTER TABLE `entidadfederativa` DISABLE KEYS */;
INSERT INTO `entidadfederativa` VALUES (1,1,'AGUASCALIENTES','AGS  '),(2,2,'BAJA CALIFORNIA','BC   '),(3,3,'BAJA CALIFORNIA SUR','BCS  '),(4,4,'CAMPECHE','CAMP '),(5,5,'COAHUILA DE ZARAGOZA','COAH '),(6,6,'COLIMA','COL  '),(7,7,'CHIAPAS','CHIS '),(8,8,'CHIHUAHUA','CHIH '),(9,9,'CIUDAD DE MÉXICO','CDMX '),(10,10,'DURANGO','DGO  '),(11,11,'GUANAJUATO','GTO  '),(12,12,'GUERRERO','GRO  '),(13,13,'HIDALGO','HGO  '),(14,14,'JALISCO','JAL  '),(15,15,'MÉXICO','MEX  '),(16,16,'MICHOACÁN DE OCAMPO','MICH '),(17,17,'MORELOS','MOR  '),(18,18,'NAYARIT','NAY  '),(19,19,'NUEVO LEÓN','NL   '),(20,20,'OAXACA','OAX  '),(21,21,'PUEBLA','PUE  '),(22,22,'QUERÉTARO','QRO  '),(23,23,'QUINTANA ROO','QROO '),(24,24,'SAN LUIS POTOSÍ','SLP  '),(25,25,'SINALOA','SIN  '),(26,26,'SONORA','SON  '),(27,27,'TABASCO','TAB  '),(28,28,'TAMAULIPAS','TAMPS'),(29,29,'TLAXCALA','TLAX '),(30,30,'VERACRUZ DE IGNACIO DE LA LLAVE','VER  '),(31,31,'YUCATÁN','YUC  '),(32,32,'ZACATECAS','ZAC  '),(33,33,'EXTRANJERO','EXT');
/*!40000 ALTER TABLE `entidadfederativa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estaustitulo`
--

DROP TABLE IF EXISTS `estaustitulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estaustitulo` (
  `idestaustitulo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idestaustitulo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estaustitulo`
--

LOCK TABLES `estaustitulo` WRITE;
/*!40000 ALTER TABLE `estaustitulo` DISABLE KEYS */;
INSERT INTO `estaustitulo` VALUES (1,'envio'),(2,'consulta'),(3,'descarga');
/*!40000 ALTER TABLE `estaustitulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `firmastitulo`
--

DROP TABLE IF EXISTS `firmastitulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `firmastitulo` (
  `idfirmatitulo` bigint(20) NOT NULL AUTO_INCREMENT,
  `idtitulo` int(11) NOT NULL,
  `idusuario` int(11) NOT NULL,
  `fechahorafirma` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idfirmatitulo`),
  KEY `firmastitulo_fk` (`idusuario`),
  KEY `firmastitulo_fk_1` (`idtitulo`),
  CONSTRAINT `firmastitulo_fk` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`),
  CONSTRAINT `firmastitulo_fk_1` FOREIGN KEY (`idtitulo`) REFERENCES `titulo` (`idtitulo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `firmastitulo`
--

LOCK TABLES `firmastitulo` WRITE;
/*!40000 ALTER TABLE `firmastitulo` DISABLE KEYS */;
INSERT INTO `firmastitulo` VALUES (1,7,2,NULL),(2,5,2,NULL),(3,7,1,NULL),(4,2,1,NULL);
/*!40000 ALTER TABLE `firmastitulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fundamentolegalserviciosocial`
--

DROP TABLE IF EXISTS `fundamentolegalserviciosocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fundamentolegalserviciosocial` (
  `id_fundamento_legal_servicio_social` int(11) NOT NULL AUTO_INCREMENT,
  `fundamento_legal_servicio_social` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_fundamento_legal_servicio_social`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fundamentolegalserviciosocial`
--

LOCK TABLES `fundamentolegalserviciosocial` WRITE;
/*!40000 ALTER TABLE `fundamentolegalserviciosocial` DISABLE KEYS */;
INSERT INTO `fundamentolegalserviciosocial` VALUES (1,'ART. 52 LRART. 5 CONST'),(2,'ART. 55 LRART. 5 CONST'),(3,'ART. 91 RLRART. 5 CONST'),(4,'ART. 10 REGLAMENTO PARA LA PRESTACIÓN DEL SERVICIO SOCIAL DE LOS ESTUDIANTES DE LAS INSTITUCIONES DE EDUCACIÓN SUPERIOR EN LA REPÚBLICA MEXICANA '),(5,'NO APLICA'),(7,'De acuerdo con la cuarta T');
/*!40000 ALTER TABLE `fundamentolegalserviciosocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historicoenvio`
--

DROP TABLE IF EXISTS `historicoenvio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historicoenvio` (
  `idhistoricoenvio` int(11) NOT NULL AUTO_INCREMENT,
  `idusuario` int(11) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `accion` varchar(10) DEFAULT NULL,
  `mensaje` varchar(200) DEFAULT NULL,
  `lote` int(11) DEFAULT NULL,
  `idestaustitulo` int(11) DEFAULT NULL,
  `archivo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idhistoricoenvio`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historicoenvio`
--

LOCK TABLES `historicoenvio` WRITE;
/*!40000 ALTER TABLE `historicoenvio` DISABLE KEYS */;
INSERT INTO `historicoenvio` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,'/opt/archivos/zips/1-130421.zip'),(11,NULL,NULL,NULL,'El usuario 140349 no pertenece a la Institución Educativa.',161907,3,'c:\\archivos\\zips\\11-220421.zip'),(13,NULL,NULL,NULL,'El usuario 140349 no pertenece a la Institución Educativa.',162741,3,'c:\\archivos\\zips\\13-220421.zip');
/*!40000 ALTER TABLE `historicoenvio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historicorecibo`
--

DROP TABLE IF EXISTS `historicorecibo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historicorecibo` (
  `Idhistoricorecibo` int(11) NOT NULL AUTO_INCREMENT,
  `idhistoricoenvio` int(11) NOT NULL,
  `datestamp` datetime NOT NULL,
  `archivo` varchar(100) DEFAULT NULL,
  `mensaje` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Idhistoricorecibo`),
  KEY `historicorecibo_FK` (`idhistoricoenvio`),
  CONSTRAINT `historicorecibo_FK` FOREIGN KEY (`idhistoricoenvio`) REFERENCES `historicoenvio` (`idhistoricoenvio`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historicorecibo`
--

LOCK TABLES `historicorecibo` WRITE;
/*!40000 ALTER TABLE `historicorecibo` DISABLE KEYS */;
INSERT INTO `historicorecibo` VALUES (37,1,'2020-04-29 00:00:00','/opt/archivos/respzips/1-2904201253/ResultadoCargaTitulos1.xls',NULL),(38,1,'2020-04-29 00:00:00','/opt/archivos/respzips/1-2904201214/ResultadoCargaTitulos1.xls',NULL),(39,1,'2020-04-29 00:00:00','/opt/archivos/respzips/1-2904201235/ResultadoCargaTitulos1.xls',NULL),(40,1,'2020-04-29 00:00:00','/opt/archivos/respzips/1-2904201236/ResultadoCargaTitulos1.xls',NULL),(41,11,'2021-04-13 00:00:00','/opt/archivos/respzips/11-1304211339/ResultadoCargaTitulos1.xls',NULL),(42,11,'2021-04-13 00:00:00','/opt/archivos/respzips/11-1304211315/ResultadoCargaTitulos1.xls',NULL);
/*!40000 ALTER TABLE `historicorecibo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institucion`
--

DROP TABLE IF EXISTS `institucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `institucion` (
  `institucion_id` int(11) NOT NULL,
  `nombre_institucion` varchar(100) DEFAULT NULL,
  `id_entidad_federativa` int(11) DEFAULT NULL,
  PRIMARY KEY (`institucion_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `institucion`
--

LOCK TABLES `institucion` WRITE;
/*!40000 ALTER TABLE `institucion` DISABLE KEYS */;
INSERT INTO `institucion` VALUES (140349,'CENTRO DE INVESTIGACIÓN Y ASISTENCIA EN TECNOLOGÍA Y DISEÑO DEL ESTADO DE JALISCO, A.C.',14);
/*!40000 ALTER TABLE `institucion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institucioncarrera`
--

DROP TABLE IF EXISTS `institucioncarrera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `institucioncarrera` (
  `idinstitucioncarrera` int(11) NOT NULL AUTO_INCREMENT,
  `institucion_id` int(11) DEFAULT NULL,
  `cve_carrera` int(11) DEFAULT NULL,
  PRIMARY KEY (`idinstitucioncarrera`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `institucioncarrera`
--

LOCK TABLES `institucioncarrera` WRITE;
/*!40000 ALTER TABLE `institucioncarrera` DISABLE KEYS */;
INSERT INTO `institucioncarrera` VALUES (1,140349,320577),(2,140349,411598),(3,140349,644621),(4,140349,128528);
/*!40000 ALTER TABLE `institucioncarrera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logacciones`
--

DROP TABLE IF EXISTS `logacciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logacciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(500) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `data` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logacciones`
--

LOCK TABLES `logacciones` WRITE;
/*!40000 ALTER TABLE `logacciones` DISABLE KEYS */;
INSERT INTO `logacciones` VALUES (5,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-14 00:00:00','/titulo/guardar','Titulo(idtitulo=2, curp=CACX7605101P8, nombre=Manuel, primerapellido=Lopez, segundoapellido=Pereira, correoelectronico=mlopez@saber.com, fechainicio=Sun Dec 31 18:00:00 CST 2017, fechaterminacion=Fri Jan 31 18:00:00 CST 2020, fechaexpedicion=Wed Mar 18 18:00:00 CST 2020, fechaexamenprofesional=Tue Mar 17 18:00:00 CST 2020, fechaexencionexamenprofecional=null, cumplioserviciosocial=1, institucionprocedencia=uteg, fechainicio_procedencia=Tue Dec 31 18:00:00 CST 2013, fechaterminacion_procedencia=Thu Nov 30 18:00:00 CST 2017, nocedula=sdfg4556, lote=null, nombrexmlenvio=null, tituloxml=null, institucioncarrera=institucioncarrera(idinstitucioncarrera=2, institucion=institucion(institucion_id=140349, nombre_institucion=CENTRO DE INVESTIGACIÓN Y ASISTENCIA EN TECNOLOGÍA Y DISEÑO DEL ESTADO DE JALISCO, A.C., id_entidad_federativa=14), carrera=carrera(cve_carrera=411598, nombre_carrera=MAESTRÍA EN INVESTIGACIÓN CLÍNICA, nivel_educativo=MAESTRÍA, rvoe_dgp=null, tipo_rvoe=null, id_entidad_federativa_rvoe=null, sostenimiento=FEDERAL)), modalidadtitulacion=ModalidadTitulacion(id_modalidad_titulacion=2, modalidad_titulacion=POR PROMEDIO, tipo_de_modalidad=CONSTANCIA DE EXENCIÓN), fundamentoLegalServicioSocial=FundamentoLegalServicioSocial(id_fundamento_legal_servicio_social=3, fundamento_legal_servicio_social=ART. 91 RLRART. 5 CONST), entidadFederativa=entidadFederativa(identidadfederativa=15, c_nom_ent=MÉXICO, c_entidad_abr=MEX  ), entidadFederativa_procedencia=entidadFederativa(identidadfederativa=15, c_nom_ent=MÉXICO, c_entidad_abr=MEX  ), autorizacionReconocimiento=AutorizacionReconocimiento(id_autorizacion_reconocimiento=3, autorizacion_reconocimiento=AUTORIZACIÓN FEDERAL), tipostudioAntecedente=TipoEstudioAntecedente(id_tipo_estudio_antecedente=2, tipo_estudio_antecedente=LICENCIATURA, tipo_educativo_del_antecedente=EDUCACIÓN SUPERIOR), historicoenvio=null)'),(6,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-14 14:47:19','/titulo/guardar','Titulo(idtitulo=2, curp=CACX7605101P8, nombre=Manuel, primerapellido=Lopez, segundoapellido=Pereira, correoelectronico=mlopez@saber.com, fechainicio=Sun Dec 31 18:00:00 CST 2017, fechaterminacion=Fri Jan 31 18:00:00 CST 2020, fechaexpedicion=Wed Mar 18 18:00:00 CST 2020, fechaexamenprofesional=Tue Mar 17 18:00:00 CST 2020, fechaexencionexamenprofecional=null, cumplioserviciosocial=1, institucionprocedencia=uteg, fechainicio_procedencia=Tue Dec 31 18:00:00 CST 2013, fechaterminacion_procedencia=Thu Nov 30 18:00:00 CST 2017, nocedula=sdfg4556, lote=null, nombrexmlenvio=null, tituloxml=null, institucioncarrera=institucioncarrera(idinstitucioncarrera=2, institucion=institucion(institucion_id=140349, nombre_institucion=CENTRO DE INVESTIGACIÓN Y ASISTENCIA EN TECNOLOGÍA Y DISEÑO DEL ESTADO DE JALISCO, A.C., id_entidad_federativa=14), carrera=carrera(cve_carrera=411598, nombre_carrera=MAESTRÍA EN INVESTIGACIÓN CLÍNICA, nivel_educativo=MAESTRÍA, rvoe_dgp=null, tipo_rvoe=null, id_entidad_federativa_rvoe=null, sostenimiento=FEDERAL)), modalidadtitulacion=ModalidadTitulacion(id_modalidad_titulacion=2, modalidad_titulacion=POR PROMEDIO, tipo_de_modalidad=CONSTANCIA DE EXENCIÓN), fundamentoLegalServicioSocial=FundamentoLegalServicioSocial(id_fundamento_legal_servicio_social=3, fundamento_legal_servicio_social=ART. 91 RLRART. 5 CONST), entidadFederativa=entidadFederativa(identidadfederativa=15, c_nom_ent=MÉXICO, c_entidad_abr=MEX  ), entidadFederativa_procedencia=entidadFederativa(identidadfederativa=15, c_nom_ent=MÉXICO, c_entidad_abr=MEX  ), autorizacionReconocimiento=AutorizacionReconocimiento(id_autorizacion_reconocimiento=3, autorizacion_reconocimiento=AUTORIZACIÓN FEDERAL), tipostudioAntecedente=TipoEstudioAntecedente(id_tipo_estudio_antecedente=2, tipo_estudio_antecedente=LICENCIATURA, tipo_educativo_del_antecedente=EDUCACIÓN SUPERIOR), historicoenvio=null)'),(7,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:14:02','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(8,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:15:29','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=3, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(9,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:15:29','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=3, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(10,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:15:43','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=4, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(11,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:15:50','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(12,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:17:33','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(13,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:18:02','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(14,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:18:37','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(15,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:18:38','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(16,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:18:58','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(17,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:18:58','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(18,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:19:16','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(19,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:19:16','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(20,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:20:06','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(21,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:20:07','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(22,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:20:16','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(23,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:20:16','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(24,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:21:20','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(25,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:21:20','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(26,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:23:50','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(27,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:23:51','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(28,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:24:42','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(29,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:24:44','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(30,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:25:12','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(31,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 15:25:13','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(32,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-15 18:08:47','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(33,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-18 14:44:25','/catalogo/responsable/guardar','Responsable(idresponsable=2, nombre=Hector, primerapellido=Lopez, segundoapellido=Leiva, curp=uiop, abrtitulo=dr, certificadoresponsable=jufa7608212v6.cer, llaveesponsable=Claveprivada_FIEL_JUFA7608212V6_20190528_162132.key, numerocertificado=30001000000400002304, pwdkey=, cargo=Cargo(id_cargo=2, cargo_firmante=SUBDIRECTOR))'),(34,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-18 15:45:30','/catalogo/responsable/guardar','Responsable(idresponsable=2, nombre=Hector, primerapellido=Lopez, segundoapellido=Leiva, curp=uiop, abrtitulo=dr, certificadoresponsable=jufa7608212v6.cer, llaveesponsable=Claveprivada_FIEL_JUFA7608212V6_20190528_162132.key, numerocertificado=30001000000400002304, pwdkey=12345, cargo=Cargo(id_cargo=2, cargo_firmante=SUBDIRECTOR))'),(35,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-18 19:55:21','/catalogo/responsable/guardar','Responsable(idresponsable=2, nombre=Hector, primerapellido=Lopes, segundoapellido=Leiva, curp=uiop, abrtitulo=dr, certificadoresponsable=jufa7608212v6.cer, llaveesponsable=Claveprivada_FIEL_JUFA7608212V6_20190528_162132.key, numerocertificado=30001000000400002304, pwdkey=, cargo=Cargo(id_cargo=2, cargo_firmante=SUBDIRECTOR))'),(36,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-18 19:56:55','/catalogo/responsable/guardar','Responsable(idresponsable=2, nombre=Hector, primerapellido=Lopes, segundoapellido=Leiva, curp=uiop, abrtitulo=dr, certificadoresponsable=jufa7608212v6.cer, llaveesponsable=Claveprivada_FIEL_JUFA7608212V6_20190528_162132.key, numerocertificado=30001000000400002304, pwdkey=1234, cargo=Cargo(id_cargo=2, cargo_firmante=SUBDIRECTOR))'),(37,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-18 20:04:27','/catalogo/responsable/guardar','Responsable(idresponsable=null, nombre=Antonio, primerapellido=Jaramillo, segundoapellido=Segura, curp=funk671228ph6hjliku09, abrtitulo=dr, certificadoresponsable=null, llaveesponsable=null, numerocertificado=null, pwdkey=null, cargo=Cargo(id_cargo=1, cargo_firmante=DIRECTOR))'),(38,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-18 20:06:02','/catalogo/responsable/guardar','Responsable(idresponsable=null, nombre=Jaime, primerapellido=Jaramillo, segundoapellido=Loza, curp=funk671228ph6hjliku, abrtitulo=dr, certificadoresponsable=null, llaveesponsable=null, numerocertificado=null, pwdkey=null, cargo=Cargo(id_cargo=1, cargo_firmante=DIRECTOR))'),(39,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-18 20:07:36','/upload/cert/resp/','Responsable(idresponsable=3, nombre=null, primerapellido=null, segundoapellido=null, curp=null, abrtitulo=null, certificadoresponsable=null, llaveesponsable=null, numerocertificado=null, pwdkey=null, cargo=null)'),(40,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-18 20:07:59','/upload/cert/resp/','Responsable(idresponsable=3, nombre=null, primerapellido=null, segundoapellido=null, curp=null, abrtitulo=null, certificadoresponsable=null, llaveesponsable=null, numerocertificado=null, pwdkey=null, cargo=null)'),(41,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-18 20:08:30','/catalogo/responsable/guardar','Responsable(idresponsable=3, nombre=Jaime, primerapellido=Jaramillo, segundoapellido=Loza, curp=funk671228ph6hjliku, abrtitulo=dr, certificadoresponsable=funk671228ph6.cer, llaveesponsable=FIEL_FUNK671228PH6.key, numerocertificado=, pwdkey=123456789a, cargo=Cargo(id_cargo=1, cargo_firmante=DIRECTOR))'),(42,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-18 20:25:47','/catalogo/responsable/guardar','Responsable(idresponsable=3, nombre=Jaime, primerapellido=Jaramillo, segundoapellido=Loza, curp=funk671228ph6hjliku, abrtitulo=dr, certificadoresponsable=funk671228ph6.cer, llaveesponsable=FIEL_FUNK671228PH6.key, numerocertificado=000100000040000200, pwdkey=123456789a, cargo=Cargo(id_cargo=1, cargo_firmante=DIRECTOR))'),(43,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-19 00:42:58','/upload/cert/resp/','Responsable(idresponsable=3, nombre=null, primerapellido=null, segundoapellido=null, curp=null, abrtitulo=null, certificadoresponsable=null, llaveesponsable=null, numerocertificado=null, pwdkey=null, cargo=null)'),(44,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-19 00:43:48','/upload/cert/resp/','Responsable(idresponsable=3, nombre=null, primerapellido=null, segundoapellido=null, curp=null, abrtitulo=null, certificadoresponsable=null, llaveesponsable=null, numerocertificado=null, pwdkey=null, cargo=null)'),(45,'admin[ROLE_ADMIN, ROLE_USER]','2020-05-19 00:46:39','/catalogo/responsable/guardar','Responsable(idresponsable=3, nombre=Jaime, primerapellido=Jaramillo, segundoapellido=Loza, curp=funk671228ph6hjliku, abrtitulo=dr, certificadoresponsable=funk671228ph6.cer, llaveesponsable=FIEL_FUNK671228PH6.key, numerocertificado=000100000040000202, pwdkey=123456789a, cargo=Cargo(id_cargo=1, cargo_firmante=DIRECTOR))'),(46,'admin[ROLE_ADMIN, ROLE_USER]','2020-06-22 20:57:13','/titulo/descarga/','Titulo(idtitulo=2, curp=CACX7605101P8, nombre=Manuel, primerapellido=Lopez, segundoapellido=Pereira, correoelectronico=mlopez@saber.com, fechainicio=2017-12-31, fechaterminacion=2020-01-31, fechaexpedicion=2020-03-18, fechaexamenprofesional=2020-03-17, fechaexencionexamenprofecional=null, cumplioserviciosocial=1, institucionprocedencia=uteg, fechainicio_procedencia=2013-12-31, fechaterminacion_procedencia=2017-11-30, nocedula=sdfg4556, lote=null, nombrexmlenvio=null, tituloxml=null, institucioncarrera=institucioncarrera(idinstitucioncarrera=2, institucion=institucion(institucion_id=140349, nombre_institucion=CENTRO DE INVESTIGACIÓN Y ASISTENCIA EN TECNOLOGÍA Y DISEÑO DEL ESTADO DE JALISCO, A.C., id_entidad_federativa=14), carrera=carrera(cve_carrera=411598, nombre_carrera=MAESTRÍA EN INVESTIGACIÓN CLÍNICA, nivel_educativo=MAESTRÍA, rvoe_dgp=null, tipo_rvoe=null, id_entidad_federativa_rvoe=null, sostenimiento=FEDERAL)), modalidadtitulacion=ModalidadTitulacion(id_modalidad_titulacion=2, modalidad_titulacion=POR PROMEDIO, tipo_de_modalidad=CONSTANCIA DE EXENCIÓN), fundamentoLegalServicioSocial=FundamentoLegalServicioSocial(id_fundamento_legal_servicio_social=3, fundamento_legal_servicio_social=ART. 91 RLRART. 5 CONST), entidadFederativa=entidadFederativa(identidadfederativa=15, c_nom_ent=MÉXICO, c_entidad_abr=MEX  ), entidadFederativa_procedencia=entidadFederativa(identidadfederativa=15, c_nom_ent=MÉXICO, c_entidad_abr=MEX  ), autorizacionReconocimiento=AutorizacionReconocimiento(id_autorizacion_reconocimiento=3, autorizacion_reconocimiento=AUTORIZACIÓN FEDERAL), tipostudioAntecedente=TipoEstudioAntecedente(id_tipo_estudio_antecedente=2, tipo_estudio_antecedente=LICENCIATURA, tipo_educativo_del_antecedente=EDUCACIÓN SUPERIOR), historicoenvio=null)'),(47,'admin[ROLE_ADMIN, ROLE_USER]','2020-06-22 20:57:21','/titulo/descarga/','Titulo(idtitulo=2, curp=CACX7605101P8, nombre=Manuel, primerapellido=Lopez, segundoapellido=Pereira, correoelectronico=mlopez@saber.com, fechainicio=2017-12-31, fechaterminacion=2020-01-31, fechaexpedicion=2020-03-18, fechaexamenprofesional=2020-03-17, fechaexencionexamenprofecional=null, cumplioserviciosocial=1, institucionprocedencia=uteg, fechainicio_procedencia=2013-12-31, fechaterminacion_procedencia=2017-11-30, nocedula=sdfg4556, lote=null, nombrexmlenvio=null, tituloxml=null, institucioncarrera=institucioncarrera(idinstitucioncarrera=2, institucion=institucion(institucion_id=140349, nombre_institucion=CENTRO DE INVESTIGACIÓN Y ASISTENCIA EN TECNOLOGÍA Y DISEÑO DEL ESTADO DE JALISCO, A.C., id_entidad_federativa=14), carrera=carrera(cve_carrera=411598, nombre_carrera=MAESTRÍA EN INVESTIGACIÓN CLÍNICA, nivel_educativo=MAESTRÍA, rvoe_dgp=null, tipo_rvoe=null, id_entidad_federativa_rvoe=null, sostenimiento=FEDERAL)), modalidadtitulacion=ModalidadTitulacion(id_modalidad_titulacion=2, modalidad_titulacion=POR PROMEDIO, tipo_de_modalidad=CONSTANCIA DE EXENCIÓN), fundamentoLegalServicioSocial=FundamentoLegalServicioSocial(id_fundamento_legal_servicio_social=3, fundamento_legal_servicio_social=ART. 91 RLRART. 5 CONST), entidadFederativa=entidadFederativa(identidadfederativa=15, c_nom_ent=MÉXICO, c_entidad_abr=MEX  ), entidadFederativa_procedencia=entidadFederativa(identidadfederativa=15, c_nom_ent=MÉXICO, c_entidad_abr=MEX  ), autorizacionReconocimiento=AutorizacionReconocimiento(id_autorizacion_reconocimiento=3, autorizacion_reconocimiento=AUTORIZACIÓN FEDERAL), tipostudioAntecedente=TipoEstudioAntecedente(id_tipo_estudio_antecedente=2, tipo_estudio_antecedente=LICENCIATURA, tipo_educativo_del_antecedente=EDUCACIÓN SUPERIOR), historicoenvio=null)'),(48,'admin[ROLE_ADMIN, ROLE_USER]','2020-06-22 21:04:16','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(49,'admin[ROLE_ADMIN, ROLE_USER]','2020-06-23 14:45:38','/titulo/descarga/','Titulo(idtitulo=2, curp=CACX7605101P8, nombre=Manuel, primerapellido=Lopez, segundoapellido=Pereira, correoelectronico=mlopez@saber.com, fechainicio=2017-12-31, fechaterminacion=2020-01-31, fechaexpedicion=2020-03-18, fechaexamenprofesional=2020-03-17, fechaexencionexamenprofecional=null, cumplioserviciosocial=1, institucionprocedencia=uteg, fechainicio_procedencia=2013-12-31, fechaterminacion_procedencia=2017-11-30, nocedula=sdfg4556, lote=null, nombrexmlenvio=null, tituloxml=null, institucioncarrera=institucioncarrera(idinstitucioncarrera=2, institucion=institucion(institucion_id=140349, nombre_institucion=CENTRO DE INVESTIGACIÓN Y ASISTENCIA EN TECNOLOGÍA Y DISEÑO DEL ESTADO DE JALISCO, A.C., id_entidad_federativa=14), carrera=carrera(cve_carrera=411598, nombre_carrera=MAESTRÍA EN INVESTIGACIÓN CLÍNICA, nivel_educativo=MAESTRÍA, rvoe_dgp=null, tipo_rvoe=null, id_entidad_federativa_rvoe=null, sostenimiento=FEDERAL)), modalidadtitulacion=ModalidadTitulacion(id_modalidad_titulacion=2, modalidad_titulacion=POR PROMEDIO, tipo_de_modalidad=CONSTANCIA DE EXENCIÓN), fundamentoLegalServicioSocial=FundamentoLegalServicioSocial(id_fundamento_legal_servicio_social=3, fundamento_legal_servicio_social=ART. 91 RLRART. 5 CONST), entidadFederativa=entidadFederativa(identidadfederativa=15, c_nom_ent=MÉXICO, c_entidad_abr=MEX  ), entidadFederativa_procedencia=entidadFederativa(identidadfederativa=15, c_nom_ent=MÉXICO, c_entidad_abr=MEX  ), autorizacionReconocimiento=AutorizacionReconocimiento(id_autorizacion_reconocimiento=3, autorizacion_reconocimiento=AUTORIZACIÓN FEDERAL), tipostudioAntecedente=TipoEstudioAntecedente(id_tipo_estudio_antecedente=2, tipo_estudio_antecedente=LICENCIATURA, tipo_educativo_del_antecedente=EDUCACIÓN SUPERIOR), historicoenvio=null)'),(50,'admin[ROLE_ADMIN, ROLE_USER]','2020-06-23 15:35:52','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(51,'admin[ROLE_ADMIN, ROLE_USER]','2020-06-23 16:02:10','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=3, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(52,'admin[ROLE_ADMIN, ROLE_USER]','2020-06-23 16:02:11','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=3, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(53,'admin[ROLE_ADMIN, ROLE_USER]','2020-06-23 16:03:07','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=4, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(54,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 17:28:49','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(55,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 17:35:54','/titulo/historicoenvio/eliminar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(56,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 17:35:59','/titulo/historicoenvio/eliminar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(57,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 17:38:36','/titulo/guardar','Titulo(idtitulo=4, curp=PEGL800910MASRNN01, nombre=Linda, primerapellido=Peres, segundoapellido=Gaona, correoelectronico=lGaona@email.com, fechainicio=Mon Apr 26 19:00:00 CDT 2010, fechaterminacion=Sun Apr 21 19:00:00 CDT 2013, fechaexpedicion=Sun Apr 21 19:00:00 CDT 2013, fechaexamenprofesional=Sun Apr 21 19:00:00 CDT 2013, fechaexencionexamenprofecional=null, cumplioserviciosocial=1, institucionprocedencia=CIATEJ, fechainicio_procedencia=Wed Apr 02 18:00:00 CST 2008, fechaterminacion_procedencia=Sun Apr 04 19:00:00 CDT 2010, nocedula=sdfsg, lote=null, nombrexmlenvio=null, tituloxml=null, institucioncarrera=institucioncarrera(idinstitucioncarrera=3, institucion=institucion(institucion_id=140349, nombre_institucion=CENTRO DE INVESTIGACIÓN Y ASISTENCIA EN TECNOLOGÍA Y DISEÑO DEL ESTADO DE JALISCO, A.C., id_entidad_federativa=14), carrera=carrera(cve_carrera=644621, nombre_carrera=DOCTORADO EN CIENCIAS EN INNOVACIÓN BIOTECNOLÓGICA, nivel_educativo=DOCTORADO, rvoe_dgp=null, tipo_rvoe=null, id_entidad_federativa_rvoe=null, sostenimiento=FEDERAL)), modalidadtitulacion=ModalidadTitulacion(id_modalidad_titulacion=1, modalidad_titulacion=POR TESIS, tipo_de_modalidad=ACTA DE EXAMEN), fundamentoLegalServicioSocial=FundamentoLegalServicioSocial(id_fundamento_legal_servicio_social=1, fundamento_legal_servicio_social=ART. 52 LRART. 5 CONST), entidadFederativa=entidadFederativa(identidadfederativa=1, c_nom_ent=AGUASCALIENTES, c_entidad_abr=AGS  ), entidadFederativa_procedencia=entidadFederativa(identidadfederativa=1, c_nom_ent=AGUASCALIENTES, c_entidad_abr=AGS  ), autorizacionReconocimiento=AutorizacionReconocimiento(id_autorizacion_reconocimiento=9, autorizacion_reconocimiento=OTRO), tipostudioAntecedente=TipoEstudioAntecedente(id_tipo_estudio_antecedente=1, tipo_estudio_antecedente=MAESTRÍA, tipo_educativo_del_antecedente=EDUCACIÓN SUPERIOR), historicoenvio=null)'),(58,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 17:38:47','/titulo/eliminar','Titulo(idtitulo=4, curp=null, nombre=null, primerapellido=null, segundoapellido=null, correoelectronico=null, fechainicio=null, fechaterminacion=null, fechaexpedicion=null, fechaexamenprofesional=null, fechaexencionexamenprofecional=null, cumplioserviciosocial=null, institucionprocedencia=null, fechainicio_procedencia=null, fechaterminacion_procedencia=null, nocedula=null, lote=null, nombrexmlenvio=null, tituloxml=null, institucioncarrera=null, modalidadtitulacion=null, fundamentoLegalServicioSocial=null, entidadFederativa=null, entidadFederativa_procedencia=null, autorizacionReconocimiento=null, tipostudioAntecedente=null, historicoenvio=null)'),(59,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 17:42:20','/titulo/xml/','Titulo(idtitulo=2, curp=CACX7605101P8, nombre=Manuel, primerapellido=Lopez, segundoapellido=Pereira, correoelectronico=mlopez@saber.com, fechainicio=2017-12-31, fechaterminacion=2020-01-31, fechaexpedicion=2020-03-18, fechaexamenprofesional=2020-03-17, fechaexencionexamenprofecional=null, cumplioserviciosocial=1, institucionprocedencia=uteg, fechainicio_procedencia=2013-12-31, fechaterminacion_procedencia=2017-11-30, nocedula=sdfg4556, lote=null, nombrexmlenvio=411598CACX7605101P8.xml, tituloxml=null, institucioncarrera=institucioncarrera(idinstitucioncarrera=2, institucion=institucion(institucion_id=140349, nombre_institucion=CENTRO DE INVESTIGACIÓN Y ASISTENCIA EN TECNOLOGÍA Y DISEÑO DEL ESTADO DE JALISCO, A.C., id_entidad_federativa=14), carrera=carrera(cve_carrera=411598, nombre_carrera=MAESTRÍA EN INVESTIGACIÓN CLÍNICA, nivel_educativo=MAESTRÍA, rvoe_dgp=null, tipo_rvoe=null, id_entidad_federativa_rvoe=null, sostenimiento=FEDERAL)), modalidadtitulacion=ModalidadTitulacion(id_modalidad_titulacion=2, modalidad_titulacion=POR PROMEDIO, tipo_de_modalidad=CONSTANCIA DE EXENCIÓN), fundamentoLegalServicioSocial=FundamentoLegalServicioSocial(id_fundamento_legal_servicio_social=3, fundamento_legal_servicio_social=ART. 91 RLRART. 5 CONST), entidadFederativa=entidadFederativa(identidadfederativa=15, c_nom_ent=MÉXICO, c_entidad_abr=MEX  ), entidadFederativa_procedencia=entidadFederativa(identidadfederativa=15, c_nom_ent=MÉXICO, c_entidad_abr=MEX  ), autorizacionReconocimiento=AutorizacionReconocimiento(id_autorizacion_reconocimiento=3, autorizacion_reconocimiento=AUTORIZACIÓN FEDERAL), tipostudioAntecedente=TipoEstudioAntecedente(id_tipo_estudio_antecedente=2, tipo_estudio_antecedente=LICENCIATURA, tipo_educativo_del_antecedente=EDUCACIÓN SUPERIOR), historicoenvio=null)'),(60,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 17:44:13','/titulo/historicoenvio/eliminar/','HistoricoEnvio(idhistoricoenvio=4, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(61,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 17:44:14','/titulo/historicoenvio/eliminar/','HistoricoEnvio(idhistoricoenvio=3, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(62,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 17:44:20','/titulo/historicoenvio/eliminaritem','HistoricoEnvio(idhistoricoenvio=3, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(63,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 17:44:26','/titulo/historicoenvio/eliminar/','HistoricoEnvio(idhistoricoenvio=3, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(64,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 17:44:32','/titulo/historicoenvio/eliminar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(65,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 17:46:55','/titulo/historicoenvio/guardar','HistoricoEnvio(idhistoricoenvio=null, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(66,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 17:47:03','/titulo/historicoenvio/guardaritem','HistoricoEnvio(idhistoricoenvio=11, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(67,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 17:47:54','/titulo/historicoenvio/guardaritem','HistoricoEnvio(idhistoricoenvio=11, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(68,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 17:48:23','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=11, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(69,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 17:50:30','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=11, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(70,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 17:55:35','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=11, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(71,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 18:02:15','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=11, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(72,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 18:03:16','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=11, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(73,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 18:04:58','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=11, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(74,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 18:15:45','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=11, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(75,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 18:17:46','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=11, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(76,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 18:22:33','/titulo/historicoenvio/wsconsulta/','HistoricoEnvio(idhistoricoenvio=11, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(77,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 18:22:51','/titulo/historicoenvio/wsconsulta/','HistoricoEnvio(idhistoricoenvio=11, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(78,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 18:23:27','/titulo/historicoenvio/wsconsulta/','HistoricoEnvio(idhistoricoenvio=11, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(79,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 19:03:43','/titulo/historicoenvio/wsrecibe/','HistoricoEnvio(idhistoricoenvio=11, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(80,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 19:04:30','/titulo/historicoenvio/wsrecibe/','HistoricoEnvio(idhistoricoenvio=11, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(81,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-13 19:11:10','/titulo/historicoenvio/eliminar/','HistoricoEnvio(idhistoricoenvio=1, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(82,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 16:07:28','/titulo/guardar','Titulo(idtitulo=null, curp=ROCC790203HJCJNR03, nombre=Carlos, primerapellido=Rojo, segundoapellido=Cano, correoelectronico=charlydime@gmail.com, fechainicio=Sun Dec 31 18:00:00 CST 2017, fechaterminacion=Tue Dec 31 18:00:00 CST 2019, fechaexpedicion=Thu Dec 31 18:00:00 CST 2020, fechaexamenprofesional=Thu Dec 31 18:00:00 CST 2020, fechaexencionexamenprofecional=null, cumplioserviciosocial=0, institucionprocedencia=U de G, fechainicio_procedencia=Fri Dec 31 18:00:00 CST 1999, fechaterminacion_procedencia=Wed Dec 31 18:00:00 CST 2003, nocedula=0879087, lote=null, nombrexmlenvio=null, tituloxml=null, institucioncarrera=institucioncarrera(idinstitucioncarrera=4, institucion=institucion(institucion_id=140349, nombre_institucion=CENTRO DE INVESTIGACIÓN Y ASISTENCIA EN TECNOLOGÍA Y DISEÑO DEL ESTADO DE JALISCO, A.C., id_entidad_federativa=14), carrera=carrera(cve_carrera=128528, nombre_carrera=MAESTRÍA EN CIENCIAS EN INNOVACIÓN BIOTECNOLÓGICA, nivel_educativo=MAESTRÍA, rvoe_dgp=null, tipo_rvoe=null, id_entidad_federativa_rvoe=null, sostenimiento=FEDERAL)), modalidadtitulacion=ModalidadTitulacion(id_modalidad_titulacion=1, modalidad_titulacion=POR TESIS, tipo_de_modalidad=ACTA DE EXAMEN), fundamentoLegalServicioSocial=FundamentoLegalServicioSocial(id_fundamento_legal_servicio_social=5, fundamento_legal_servicio_social=NO APLICA), entidadFederativa=entidadFederativa(identidadfederativa=14, c_nom_ent=JALISCO, c_entidad_abr=JAL  ), entidadFederativa_procedencia=entidadFederativa(identidadfederativa=14, c_nom_ent=JALISCO, c_entidad_abr=JAL  ), autorizacionReconocimiento=AutorizacionReconocimiento(id_autorizacion_reconocimiento=2, autorizacion_reconocimiento=RVOE ESTATAL), tipostudioAntecedente=TipoEstudioAntecedente(id_tipo_estudio_antecedente=2, tipo_estudio_antecedente=LICENCIATURA, tipo_educativo_del_antecedente=EDUCACIÓN SUPERIOR), historicoenvio=null)'),(83,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 17:06:29','/catalogo/responsable/eliminar','Responsable(idresponsable=3, nombre=null, primerapellido=null, segundoapellido=null, curp=null, abrtitulo=null, certificadoresponsable=null, llaveesponsable=null, numerocertificado=null, pwdkey=null, cargo=null)'),(84,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 17:06:30','/catalogo/responsable/eliminar','Responsable(idresponsable=2, nombre=null, primerapellido=null, segundoapellido=null, curp=null, abrtitulo=null, certificadoresponsable=null, llaveesponsable=null, numerocertificado=null, pwdkey=null, cargo=null)'),(85,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 17:06:39','/titulo/xml/','Titulo(idtitulo=6, curp=ROCC790203HJCJNR03, nombre=Carlos, primerapellido=Rojo, segundoapellido=Cano, correoelectronico=charlydime@gmail.com, fechainicio=2017-12-31, fechaterminacion=2019-12-31, fechaexpedicion=2020-12-31, fechaexamenprofesional=2020-12-31, fechaexencionexamenprofecional=null, cumplioserviciosocial=0, institucionprocedencia=U de G, fechainicio_procedencia=1999-12-31, fechaterminacion_procedencia=2003-12-31, nocedula=0879087, lote=null, nombrexmlenvio=128528ROCC790203HJCJNR03.xml, tituloxml=null, institucioncarrera=institucioncarrera(idinstitucioncarrera=4, institucion=institucion(institucion_id=140349, nombre_institucion=CENTRO DE INVESTIGACIÓN Y ASISTENCIA EN TECNOLOGÍA Y DISEÑO DEL ESTADO DE JALISCO, A.C., id_entidad_federativa=14), carrera=carrera(cve_carrera=128528, nombre_carrera=MAESTRÍA EN CIENCIAS EN INNOVACIÓN BIOTECNOLÓGICA, nivel_educativo=MAESTRÍA, rvoe_dgp=null, tipo_rvoe=null, id_entidad_federativa_rvoe=null, sostenimiento=FEDERAL)), modalidadtitulacion=ModalidadTitulacion(id_modalidad_titulacion=1, modalidad_titulacion=POR TESIS, tipo_de_modalidad=ACTA DE EXAMEN), fundamentoLegalServicioSocial=FundamentoLegalServicioSocial(id_fundamento_legal_servicio_social=5, fundamento_legal_servicio_social=NO APLICA), entidadFederativa=entidadFederativa(identidadfederativa=14, c_nom_ent=JALISCO, c_entidad_abr=JAL  ), entidadFederativa_procedencia=entidadFederativa(identidadfederativa=14, c_nom_ent=JALISCO, c_entidad_abr=JAL  ), autorizacionReconocimiento=AutorizacionReconocimiento(id_autorizacion_reconocimiento=2, autorizacion_reconocimiento=RVOE ESTATAL), tipostudioAntecedente=TipoEstudioAntecedente(id_tipo_estudio_antecedente=2, tipo_estudio_antecedente=LICENCIATURA, tipo_educativo_del_antecedente=EDUCACIÓN SUPERIOR), historicoenvio=null)'),(86,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 17:43:44','/catalogo/responsable/guardar','Responsable(idresponsable=null, nombre=Carlos, primerapellido=Rojo, segundoapellido=Cano, curp=ROCC790203HJCJNR03, abrtitulo=Dr, certificadoresponsable=null, llaveesponsable=null, numerocertificado=null, pwdkey=null, cargo=Cargo(id_cargo=1, cargo_firmante=DIRECTOR))'),(87,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:00:36','/upload/cert/resp/','Responsable(idresponsable=4, nombre=null, primerapellido=null, segundoapellido=null, curp=null, abrtitulo=null, certificadoresponsable=null, llaveesponsable=null, numerocertificado=null, pwdkey=null, cargo=null)'),(88,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:00:47','/upload/cert/resp/','Responsable(idresponsable=4, nombre=null, primerapellido=null, segundoapellido=null, curp=null, abrtitulo=null, certificadoresponsable=null, llaveesponsable=null, numerocertificado=null, pwdkey=null, cargo=null)'),(89,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:01:14','/catalogo/responsable/guardar','Responsable(idresponsable=4, nombre=Carlos, primerapellido=Rojo, segundoapellido=Cano, curp=ROCC790203HJCJNR03, abrtitulo=Dr, certificadoresponsable=cacx7605101p8.cer, llaveesponsable=Claveprivada_FIEL_CACX7605101P8_20190528_152826.key, numerocertificado=000100000040000200, pwdkey=12345678, cargo=Cargo(id_cargo=1, cargo_firmante=DIRECTOR))'),(90,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:01:26','/titulo/xml/','Titulo(idtitulo=6, curp=ROCC790203HJCJNR03, nombre=Carlos, primerapellido=Rojo, segundoapellido=Cano, correoelectronico=charlydime@gmail.com, fechainicio=2017-12-31, fechaterminacion=2019-12-31, fechaexpedicion=2020-12-31, fechaexamenprofesional=2020-12-31, fechaexencionexamenprofecional=null, cumplioserviciosocial=0, institucionprocedencia=U de G, fechainicio_procedencia=1999-12-31, fechaterminacion_procedencia=2003-12-31, nocedula=0879087, lote=null, nombrexmlenvio=128528ROCC790203HJCJNR03.xml, tituloxml=null, institucioncarrera=institucioncarrera(idinstitucioncarrera=4, institucion=institucion(institucion_id=140349, nombre_institucion=CENTRO DE INVESTIGACIÓN Y ASISTENCIA EN TECNOLOGÍA Y DISEÑO DEL ESTADO DE JALISCO, A.C., id_entidad_federativa=14), carrera=carrera(cve_carrera=128528, nombre_carrera=MAESTRÍA EN CIENCIAS EN INNOVACIÓN BIOTECNOLÓGICA, nivel_educativo=MAESTRÍA, rvoe_dgp=null, tipo_rvoe=null, id_entidad_federativa_rvoe=null, sostenimiento=FEDERAL)), modalidadtitulacion=ModalidadTitulacion(id_modalidad_titulacion=1, modalidad_titulacion=POR TESIS, tipo_de_modalidad=ACTA DE EXAMEN), fundamentoLegalServicioSocial=FundamentoLegalServicioSocial(id_fundamento_legal_servicio_social=5, fundamento_legal_servicio_social=NO APLICA), entidadFederativa=entidadFederativa(identidadfederativa=14, c_nom_ent=JALISCO, c_entidad_abr=JAL  ), entidadFederativa_procedencia=entidadFederativa(identidadfederativa=14, c_nom_ent=JALISCO, c_entidad_abr=JAL  ), autorizacionReconocimiento=AutorizacionReconocimiento(id_autorizacion_reconocimiento=2, autorizacion_reconocimiento=RVOE ESTATAL), tipostudioAntecedente=TipoEstudioAntecedente(id_tipo_estudio_antecedente=2, tipo_estudio_antecedente=LICENCIATURA, tipo_educativo_del_antecedente=EDUCACIÓN SUPERIOR), historicoenvio=null)'),(91,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:02:13','/catalogo/responsable/guardar','Responsable(idresponsable=4, nombre=Carlos, primerapellido=Rojo, segundoapellido=Cano, curp=ROCC790203HJCJNR03, abrtitulo=Dr, certificadoresponsable=cacx7605101p8.cer, llaveesponsable=Claveprivada_FIEL_CACX7605101P8_20190528_152826.key, numerocertificado=000100000040000200, pwdkey=12345678a, cargo=Cargo(id_cargo=1, cargo_firmante=DIRECTOR))'),(92,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:03:45','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=11, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(93,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:04:56','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=11, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(94,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:12:32','/titulo/historicoenvio/guardar','HistoricoEnvio(idhistoricoenvio=null, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(95,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:12:37','/titulo/historicoenvio/guardaritem','HistoricoEnvio(idhistoricoenvio=12, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(96,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:13:17','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=12, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(97,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:13:17','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=12, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(98,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:13:43','/titulo/historicoenvio/eliminar/','HistoricoEnvio(idhistoricoenvio=12, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(99,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:13:50','/titulo/historicoenvio/eliminaritem','HistoricoEnvio(idhistoricoenvio=12, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(100,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:13:55','/titulo/historicoenvio/eliminar/','HistoricoEnvio(idhistoricoenvio=12, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(101,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:14:00','/titulo/eliminar','Titulo(idtitulo=6, curp=null, nombre=null, primerapellido=null, segundoapellido=null, correoelectronico=null, fechainicio=null, fechaterminacion=null, fechaexpedicion=null, fechaexamenprofesional=null, fechaexencionexamenprofecional=null, cumplioserviciosocial=null, institucionprocedencia=null, fechainicio_procedencia=null, fechaterminacion_procedencia=null, nocedula=null, lote=null, nombrexmlenvio=null, tituloxml=null, institucioncarrera=null, modalidadtitulacion=null, fundamentoLegalServicioSocial=null, entidadFederativa=null, entidadFederativa_procedencia=null, autorizacionReconocimiento=null, tipostudioAntecedente=null, historicoenvio=null)'),(102,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:17:53','/titulo/guardar','Titulo(idtitulo=null, curp=ROMC131201HJCJXRA7, nombre=Rocio , primerapellido=Muñoz, segundoapellido=Patiño, correoelectronico=rocio81@hotmail.com, fechainicio=Tue Dec 31 18:00:00 CST 2002, fechaterminacion=Wed Dec 31 18:00:00 CST 2003, fechaexpedicion=Sat Dec 31 18:00:00 CST 2011, fechaexamenprofesional=Mon Dec 31 18:00:00 CST 2012, fechaexencionexamenprofecional=null, cumplioserviciosocial=0, institucionprocedencia=U de G, fechainicio_procedencia=Thu Dec 31 18:00:00 CST 1998, fechaterminacion_procedencia=Sun Dec 31 18:00:00 CST 2000, nocedula=219873, lote=null, nombrexmlenvio=null, tituloxml=null, institucioncarrera=institucioncarrera(idinstitucioncarrera=1, institucion=institucion(institucion_id=140349, nombre_institucion=CENTRO DE INVESTIGACIÓN Y ASISTENCIA EN TECNOLOGÍA Y DISEÑO DEL ESTADO DE JALISCO, A.C., id_entidad_federativa=14), carrera=carrera(cve_carrera=320577, nombre_carrera=MAESTRÍA EN CIENCIAS DE LA FLORICULTURA, nivel_educativo=MAESTRÍA, rvoe_dgp=null, tipo_rvoe=null, id_entidad_federativa_rvoe=null, sostenimiento=FEDERAL)), modalidadtitulacion=ModalidadTitulacion(id_modalidad_titulacion=1, modalidad_titulacion=POR TESIS, tipo_de_modalidad=ACTA DE EXAMEN), fundamentoLegalServicioSocial=FundamentoLegalServicioSocial(id_fundamento_legal_servicio_social=5, fundamento_legal_servicio_social=NO APLICA), entidadFederativa=entidadFederativa(identidadfederativa=14, c_nom_ent=JALISCO, c_entidad_abr=JAL  ), entidadFederativa_procedencia=entidadFederativa(identidadfederativa=1, c_nom_ent=AGUASCALIENTES, c_entidad_abr=AGS  ), autorizacionReconocimiento=AutorizacionReconocimiento(id_autorizacion_reconocimiento=2, autorizacion_reconocimiento=RVOE ESTATAL), tipostudioAntecedente=TipoEstudioAntecedente(id_tipo_estudio_antecedente=2, tipo_estudio_antecedente=LICENCIATURA, tipo_educativo_del_antecedente=EDUCACIÓN SUPERIOR), historicoenvio=null)'),(103,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:17:57','sellodetitilo7','lmE65ilbwbEr6rIGV6RAwtYdDkFCoWIwlCFi0pyDyXVr7YUdhjuGAMKSbAy/mijQcaWU4iEkLSBYacBAhPcALHyCDvM6fNFWhwp0zcU2FOXTq5zFtym9+g2WcK8+zt3SQ7Y7ksOcjaETTj9aPtQnzAg8T1X5sLRK2V7jno0tp0p7FfR4wbqImLlsBVKsjWqEvgh5oYsP1Sn6BsGtvEafRKlsJB1/qZ7d0nMy7BwAN6sfk5tQfs5LRz31i4OeuT9SRdxmJ1rc1/mHCmGE8hoqWfPp869aLYQmDgDjF+DinDaMsyqt7anqBl22j9mbrTjqD0U6jVtUyBWrClnhreOeXQ=='),(104,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:17:57','/titulo/xml/','Titulo(idtitulo=7, curp=ROMC131201HJCJXRA7, nombre=Rocio , primerapellido=Muñoz, segundoapellido=Patiño, correoelectronico=rocio81@hotmail.com, fechainicio=2002-12-31, fechaterminacion=2003-12-31, fechaexpedicion=2011-12-31, fechaexamenprofesional=2012-12-31, fechaexencionexamenprofecional=null, cumplioserviciosocial=0, institucionprocedencia=U de G, fechainicio_procedencia=1998-12-31, fechaterminacion_procedencia=2000-12-31, nocedula=219873, lote=null, nombrexmlenvio=320577ROMC131201HJCJXRA7.xml, tituloxml=null, institucioncarrera=institucioncarrera(idinstitucioncarrera=1, institucion=institucion(institucion_id=140349, nombre_institucion=CENTRO DE INVESTIGACIÓN Y ASISTENCIA EN TECNOLOGÍA Y DISEÑO DEL ESTADO DE JALISCO, A.C., id_entidad_federativa=14), carrera=carrera(cve_carrera=320577, nombre_carrera=MAESTRÍA EN CIENCIAS DE LA FLORICULTURA, nivel_educativo=MAESTRÍA, rvoe_dgp=null, tipo_rvoe=null, id_entidad_federativa_rvoe=null, sostenimiento=FEDERAL)), modalidadtitulacion=ModalidadTitulacion(id_modalidad_titulacion=1, modalidad_titulacion=POR TESIS, tipo_de_modalidad=ACTA DE EXAMEN), fundamentoLegalServicioSocial=FundamentoLegalServicioSocial(id_fundamento_legal_servicio_social=5, fundamento_legal_servicio_social=NO APLICA), entidadFederativa=entidadFederativa(identidadfederativa=14, c_nom_ent=JALISCO, c_entidad_abr=JAL  ), entidadFederativa_procedencia=entidadFederativa(identidadfederativa=1, c_nom_ent=AGUASCALIENTES, c_entidad_abr=AGS  ), autorizacionReconocimiento=AutorizacionReconocimiento(id_autorizacion_reconocimiento=2, autorizacion_reconocimiento=RVOE ESTATAL), tipostudioAntecedente=TipoEstudioAntecedente(id_tipo_estudio_antecedente=2, tipo_estudio_antecedente=LICENCIATURA, tipo_educativo_del_antecedente=EDUCACIÓN SUPERIOR), historicoenvio=null)'),(105,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:18:08','/titulo/historicoenvio/guardar','HistoricoEnvio(idhistoricoenvio=null, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(106,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:18:14','/titulo/historicoenvio/guardaritem','HistoricoEnvio(idhistoricoenvio=13, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(107,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:18:36','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=13, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(108,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:18:36','/titulo/historicoenvio/wsenviar/','HistoricoEnvio(idhistoricoenvio=13, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(109,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:18:52','/titulo/historicoenvio/wsconsulta/','HistoricoEnvio(idhistoricoenvio=13, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(110,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:18:52','/titulo/historicoenvio/wsconsulta/','HistoricoEnvio(idhistoricoenvio=13, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(111,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:19:06','/titulo/historicoenvio/wsrecibe/','HistoricoEnvio(idhistoricoenvio=13, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])'),(112,'admin[ROLE_ADMIN, ROLE_USER]','2021-04-22 18:19:06','/titulo/historicoenvio/wsrecibe/','HistoricoEnvio(idhistoricoenvio=13, idusuario=null, timestamp=null, accion=null, mensaje=null, lote=null, idestaustitulo=null, archivo=null, titulos=[])');
/*!40000 ALTER TABLE `logacciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modalidadtitulacion`
--

DROP TABLE IF EXISTS `modalidadtitulacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modalidadtitulacion` (
  `id_modalidad_titulación` int(11) NOT NULL AUTO_INCREMENT,
  `modalidad_titulación` varchar(40) DEFAULT NULL,
  `tipo_de_modalidad` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_modalidad_titulación`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modalidadtitulacion`
--

LOCK TABLES `modalidadtitulacion` WRITE;
/*!40000 ALTER TABLE `modalidadtitulacion` DISABLE KEYS */;
INSERT INTO `modalidadtitulacion` VALUES (1,'POR TESIS','ACTA DE EXAMEN'),(2,'POR PROMEDIO','CONSTANCIA DE EXENCIÓN'),(3,'POR ESTUDIOS DE POSGRADOS','CONSTANCIA DE EXENCIÓN'),(4,'POR EXPERIENCIA LABORAL','CONSTANCIA DE EXENCIÓN'),(5,'POR CENEVAL','CONSTANCIA DE EXENCIÓN'),(6,'OTRO','CONSTANCIA DE EXENCIÓN'),(8,'honoris causa','por suerte');
/*!40000 ALTER TABLE `modalidadtitulacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motivocancelacion`
--

DROP TABLE IF EXISTS `motivocancelacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `motivocancelacion` (
  `id_motivo_can` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_cancelación` varchar(60) NOT NULL,
  `idmotivo` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_motivo_can`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motivocancelacion`
--

LOCK TABLES `motivocancelacion` WRITE;
/*!40000 ALTER TABLE `motivocancelacion` DISABLE KEYS */;
INSERT INTO `motivocancelacion` VALUES (1,'REASIGNACIÓN PARA LA CONCORDANCIA SEXO-GENÉRICA','R1'),(2,'RECONOCIMIENTO DE PATERNIDAD','R2'),(3,'CAMBIO Y MODIFICACIÓN AL NOMBRE','R3'),(4,'CASO FORTUITO O FUERZA MAYOR','R4'),(5,'OTRO','R5'),(6,'CAUSA IMPUTABLE AL PROFESIONISTA','C1'),(7,'por ogts','O1');
/*!40000 ALTER TABLE `motivocancelacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permisos`
--

DROP TABLE IF EXISTS `permisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permisos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) NOT NULL,
  `rol` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisos`
--

LOCK TABLES `permisos` WRITE;
/*!40000 ALTER TABLE `permisos` DISABLE KEYS */;
INSERT INTO `permisos` VALUES (1,'/','USER,ADMIN'),(2,'/panel','USER,ADMIN'),(3,'/catalogo/entidadfederativa','USER,ADMIN'),(4,'/catalogo/cargo','USER,ADMIN'),(5,'/catalogo/cargo/guardar','ADMIN'),(6,'/catalogo/cargo/eliminar','ADMIN'),(7,'/catalogo/tipoestudioantecedente','USER,ADMIN'),(8,'/catalogo/tipoestudioantecedente/guardar','ADMIN'),(9,'/catalogo/tipoestudioantecedente/eliminar','ADMIN'),(10,'/catalogo/fundamentolegalserviciosociales','USER,ADMIN'),(11,'/catalogo/fundamentolegalserviciosociales/guardar','ADMIN'),(12,'/catalogo/fundamentolegalserviciosociales/eliminar','ADMIN'),(13,'/catalogo/modalidadtitulacion','USER,ADMIN'),(14,'/catalogo/modalidadtitulacion/guardar','ADMIN'),(15,'/catalogo/modalidadtitulacion/eliminar','ADMIN'),(16,'/catalogo/autorizacionreconocimiento','USER,ADMIN'),(17,'/catalogo/autorizacionreconocimiento/guardar','ADMIN'),(18,'/catalogo/autorizacionreconocimiento/eliminar','ADMIN'),(19,'/catalogo/motivocancelacion','USER,ADMIN'),(20,'/catalogo/motivocancelacion/guardar','ADMIN'),(21,'/catalogo/motivocancelacion/eliminar','ADMIN'),(22,'/catalogo/carrera','USER,ADMIN'),(23,'/catalogo/carrera/guardar','ADMIN'),(24,'/catalogo/carrera/eliminar','USER,ADMIN'),(25,'/catalogo/carrera/editar/**','USER,ADMIN'),(26,'/catalogo/carrera/agregar','USER,ADMIN'),(27,'/catalogo/responsable','USER,ADMIN'),(28,'/catalogo/responsable/guardar','USER,ADMIN'),(29,'/catalogo/responsable/eliminar','USER,ADMIN'),(30,'/catalogo/responsable/editar/**','USER,ADMIN'),(31,'/catalogo/responsable/agregar','USER,ADMIN'),(32,'/upload/cert/resp/**\"','USER,ADMIN'),(33,'/titulo/historicoenvio','USER,ADMIN'),(34,'/titulo/historicoenvio/guardar','USER,ADMIN'),(35,'/titulo/historicoenvio/guardaritem','USER,ADMIN'),(36,'/titulo/historicoenvio/eliminaritem','USER,ADMIN'),(37,'/titulo/historicoenvio/eliminaritemsimple','USER,ADMIN'),(38,'/titulo/historicoenvio/eliminar/**','USER,ADMIN'),(39,'/titulo/historicoenvio/editar/**','USER,ADMIN'),(40,'/titulo/historicoenvio/agregar','USER,ADMIN'),(41,'/titulo/buscanombre/**','USER,ADMIN'),(42,'/titulo','USER,ADMIN'),(43,'/titulo/guardar','USER,ADMIN'),(44,'/titulo/eliminar','USER,ADMIN'),(45,'/titulo/editar/**','USER,ADMIN'),(46,'/titulo/agregar','USER,ADMIN'),(47,'/titulo/xml/**','USER,ADMIN'),(48,'/titulo/descarga1/**','USER,ADMIN'),(49,'/titulo/descarga/**','USER,ADMIN'),(50,'/titulo/historicoenvio/wsenviar/**','USER,ADMIN'),(51,'/titulo/historicoenvio/wsrecibe/**','USER,ADMIN'),(52,'/titulo/historicoenvio/wsconsulta/**','USER,ADMIN'),(53,'/titulo/historicoenvio/wscancela/**','USER,ADMIN'),(54,'/titulo/pdf/**','USER,ADMIN'),(55,'/ef/listar','USER,ADMIN'),(56,'/titulo/impreso/**','USER,ADMIN'),(57,'/titulo/impreso/responsables','USER,ADMIN'),(58,'/catalogo/usuario','ADMIN'),(59,'/catalogo/usuario/guardar','ADMIN'),(60,'/catalogo/usuario/eliminar/**','ADMIN'),(61,'/catalogo/usuario/editar/**','ADMIN'),(62,'/catalogo/usuario/agregar','ADMIN'),(63,'/catalogo/roles/guardar/','ADMIN'),(64,'/','USER,ADMIN'),(65,'/catalogo/roles/elimina','ADMIN'),(66,'/panel','USER,ADMIN'),(67,'/catalogo/entidadfederativa','USER,ADMIN'),(68,'/catalogo/cargo','USER,ADMIN'),(69,'/catalogo/cargo/guardar','ADMIN'),(70,'/catalogo/cargo/eliminar','ADMIN'),(71,'/catalogo/tipoestudioantecedente','USER,ADMIN'),(72,'/catalogo/tipoestudioantecedente/guardar','ADMIN'),(73,'/catalogo/tipoestudioantecedente/eliminar','ADMIN'),(74,'/catalogo/fundamentolegalserviciosociales','USER,ADMIN'),(75,'/catalogo/fundamentolegalserviciosociales/guardar','ADMIN'),(76,'/catalogo/fundamentolegalserviciosociales/eliminar','ADMIN'),(77,'/catalogo/modalidadtitulacion','USER,ADMIN'),(78,'/catalogo/modalidadtitulacion/guardar','ADMIN'),(79,'/catalogo/modalidadtitulacion/eliminar','ADMIN'),(80,'/catalogo/autorizacionreconocimiento','USER,ADMIN'),(81,'/catalogo/autorizacionreconocimiento/guardar','ADMIN'),(82,'/catalogo/autorizacionreconocimiento/eliminar','ADMIN'),(83,'/catalogo/motivocancelacion','USER,ADMIN'),(84,'/catalogo/motivocancelacion/guardar','ADMIN'),(85,'/catalogo/motivocancelacion/eliminar','ADMIN'),(86,'/catalogo/carrera','USER,ADMIN'),(87,'/catalogo/carrera/guardar','USER,ADMIN');
/*!40000 ALTER TABLE `permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsable`
--

DROP TABLE IF EXISTS `responsable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `responsable` (
  `idresponsable` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `primerapellido` varchar(30) DEFAULT NULL,
  `segundoapellido` varchar(30) DEFAULT NULL,
  `curp` varchar(20) DEFAULT NULL,
  `idcargo` int(11) DEFAULT NULL,
  `abrtitulo` varchar(10) DEFAULT NULL,
  `certificadoresponsable` varchar(500) DEFAULT NULL,
  `llaveesponsable` varchar(500) DEFAULT NULL,
  `numerocertificado` varchar(200) DEFAULT NULL,
  `pwdkey` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idresponsable`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsable`
--

LOCK TABLES `responsable` WRITE;
/*!40000 ALTER TABLE `responsable` DISABLE KEYS */;
INSERT INTO `responsable` VALUES (4,'Carlos','Rojo','Cano','ROCC790203HJCJNR03',1,'Dr','cacx7605101p8.cer','Claveprivada_FIEL_CACX7605101P8_20190528_152826.key','000100000040000200','12345678a');
/*!40000 ALTER TABLE `responsable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `idusuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `roles_FK` (`idusuario`),
  CONSTRAINT `roles_FK` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (15,'ROLE_USER',1),(16,'ROLE_ADMIN',2),(17,'ROLE_USER',2);
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoestudioantecedente`
--

DROP TABLE IF EXISTS `tipoestudioantecedente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoestudioantecedente` (
  `id_tipo_estudio_antecedente` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_estudio_antecedente` varchar(50) DEFAULT NULL,
  `tipo_educativo_del_antecedente` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_estudio_antecedente`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoestudioantecedente`
--

LOCK TABLES `tipoestudioantecedente` WRITE;
/*!40000 ALTER TABLE `tipoestudioantecedente` DISABLE KEYS */;
INSERT INTO `tipoestudioantecedente` VALUES (1,'MAESTRÍA','EDUCACIÓN SUPERIOR'),(2,'LICENCIATURA','EDUCACIÓN SUPERIOR'),(3,'TÉCNICO SUPERIOR UNIVERSITARIO','EDUCACIÓN SUPERIOR'),(4,'BACHILLERATO','EDUCACIÓN MEDIA SUPERIOR'),(5,'EQUIVALENTE A BACHILLERATO ','EDUCACIÓN MEDIA SUPERIOR'),(6,'SECUNDARIA','EDUCACIÓN BÁSICA'),(7,'La vida','Educacion Hipersuperior');
/*!40000 ALTER TABLE `tipoestudioantecedente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `titulo`
--

DROP TABLE IF EXISTS `titulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `titulo` (
  `idtitulo` int(11) NOT NULL AUTO_INCREMENT,
  `curp` varchar(20) DEFAULT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `primerapellido` varchar(30) DEFAULT NULL,
  `segundoapellido` varchar(30) DEFAULT NULL,
  `correoelectronico` varchar(100) DEFAULT NULL,
  `fechainicio` date DEFAULT NULL,
  `fechaterminacion` date DEFAULT NULL,
  `fechaexpedicion` date DEFAULT NULL,
  `idmodalidadtitulacion` int(11) DEFAULT NULL,
  `fechaexamenprofesional` date DEFAULT NULL,
  `cumplioserviciosocial` varchar(1) DEFAULT NULL,
  `idfundamentolegalserviciosocial` int(11) DEFAULT NULL,
  `identidadfederativa` int(11) DEFAULT NULL,
  `institucionprocedencia` varchar(200) DEFAULT NULL,
  `identidadfederativa_procedencia` int(11) DEFAULT NULL,
  `fechainicio_procedencia` date DEFAULT NULL,
  `fechaterminacion_procedencia` date DEFAULT NULL,
  `nocedula` varchar(30) DEFAULT NULL,
  `lote` int(11) DEFAULT NULL,
  `nombrexmlenvio` varchar(200) DEFAULT NULL,
  `idestatustitulo` int(11) DEFAULT NULL,
  `tituloxml` varchar(200) DEFAULT NULL,
  `idinstitucioncarrera` int(11) DEFAULT NULL,
  `idautorizacionReconocimiento` int(11) DEFAULT NULL,
  `fechaexencionexamenprofecional` date DEFAULT NULL,
  `idtipoestudioantecedente` int(11) DEFAULT NULL,
  `idhistoricoenvio` int(11) DEFAULT NULL,
  PRIMARY KEY (`idtitulo`),
  KEY `titulo_FK` (`idhistoricoenvio`),
  CONSTRAINT `titulo_FK` FOREIGN KEY (`idhistoricoenvio`) REFERENCES `historicoenvio` (`idhistoricoenvio`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `titulo`
--

LOCK TABLES `titulo` WRITE;
/*!40000 ALTER TABLE `titulo` DISABLE KEYS */;
INSERT INTO `titulo` VALUES (2,'CACX7605101P8','Manuel','Lopez','Pereira','mlopez@saber.com','2018-01-01','2020-02-01','2020-03-19',2,'2020-03-18','1',3,15,'uteg',15,'2014-01-01','2017-12-01','sdfg4556',NULL,'411598CACX7605101P8.xml',NULL,NULL,2,3,NULL,2,11),(5,'OISR800603HCSLGG04','Rogelio','Olivaez','Segura','rolivaez@email.com','2018-02-01','2020-02-01','2020-03-01',1,'2020-02-15','1',1,14,'UDQ',22,'2000-09-01','2004-06-09','dddddd',NULL,'320577OISR800603HCSLGG04.xml',NULL,NULL,1,1,NULL,2,11),(7,'ROMC131201HJCJXRA7','Rocio ','Muñoz','Patiño','rocio81@hotmail.com','2003-01-01','2004-01-01','2012-01-01',1,'2013-01-01','0',5,14,'U de G',1,'1999-01-01','2001-01-01','219873',NULL,'320577ROMC131201HJCJXRA7.xml',NULL,NULL,1,2,NULL,2,13);
/*!40000 ALTER TABLE `titulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tituloresponsable`
--

DROP TABLE IF EXISTS `tituloresponsable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tituloresponsable` (
  `idtituloresponsable` int(11) NOT NULL AUTO_INCREMENT,
  `idtitulo` int(11) DEFAULT NULL,
  `idresponsable` int(11) DEFAULT NULL,
  PRIMARY KEY (`idtituloresponsable`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tituloresponsable`
--

LOCK TABLES `tituloresponsable` WRITE;
/*!40000 ALTER TABLE `tituloresponsable` DISABLE KEYS */;
/*!40000 ALTER TABLE `tituloresponsable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `nomina` varchar(10) DEFAULT NULL,
  `user` varchar(100) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `activo` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Carlos Rojo','1897','crojo','$2a$10$dgIeSq9uUwqNK1TY.3Y.eeROfazCb78/y3BgeVtatosNLmXjxa.i6','crojo@ciatej.mx',NULL),(2,'admin','000','admin','$2a$10$dSI8jkMvFg800WCwkQjFv.K76OKvUFH.DAt66RGGRkrwt1GLMqr7q','admin@ciatej',NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'titulos'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-26 11:20:26
