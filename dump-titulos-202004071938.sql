-- MySQL dump 10.13  Distrib 5.7.28, for Linux (x86_64)
--
-- Host: localhost    Database: titulos
-- ------------------------------------------------------
-- Server version	5.7.28-0ubuntu0.19.04.2

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estaustitulo`
--

LOCK TABLES `estaustitulo` WRITE;
/*!40000 ALTER TABLE `estaustitulo` DISABLE KEYS */;
/*!40000 ALTER TABLE `estaustitulo` ENABLE KEYS */;
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
  `idtitulo` int(11) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `accion` varchar(10) DEFAULT NULL,
  `mensaje` varchar(200) DEFAULT NULL,
  `lote` int(11) DEFAULT NULL,
  `idestaustitulo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idhistoricoenvio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historicoenvio`
--

LOCK TABLES `historicoenvio` WRITE;
/*!40000 ALTER TABLE `historicoenvio` DISABLE KEYS */;
/*!40000 ALTER TABLE `historicoenvio` ENABLE KEYS */;
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
  `numeroCertificado` varchar(200) DEFAULT NULL,
  `pwdKey` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idresponsable`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsable`
--

LOCK TABLES `responsable` WRITE;
/*!40000 ALTER TABLE `responsable` DISABLE KEYS */;
INSERT INTO `responsable` VALUES (2,'Hector','verch','','',1,'dr',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `responsable` ENABLE KEYS */;
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
  PRIMARY KEY (`idtitulo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `titulo`
--

LOCK TABLES `titulo` WRITE;
/*!40000 ALTER TABLE `titulo` DISABLE KEYS */;
INSERT INTO `titulo` VALUES (2,'sdgdsfg','Manuel','Lopez','Pereira','mlopez@saber.com','2020-03-02','2020-03-27','2020-03-19',5,'2020-03-18','1',1,14,'uteg',14,'2020-03-11','2020-03-24','sdfg4556',NULL,NULL,NULL,NULL,4,NULL,NULL,NULL);
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
  `nombrecompleto` varchar(50) DEFAULT NULL,
  `nomnina` varchar(10) DEFAULT NULL,
  `user` varchar(100) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `actitivo` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
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

-- Dump completed on 2020-04-07 19:38:29
