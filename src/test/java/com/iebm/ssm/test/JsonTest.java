package com.iebm.ssm.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 *TODO
 *LC
 *下午6:48:12
*/


public class JsonTest {
	
	@Test
	  public void f() throws IOException {
		  String json = "{\"aggValues\":[],\"page\":{\"currentPage\":1,\"pageRecords\":30,\"totalPages\":9,\"totalRecords\":253},\"rows\":[{\"data\":[\"1\",\"2020-05-16 09:05:02\",\"他克莫司\",\"软膏剂\",\"\",\"他克莫司软膏\",\"\",\"\",\"0\",\"\",\"\",\"9.8\",\"10\",\"乙类\",\"疑似违规\",\"\",\"\",\"\"],\"id\":\"86855066\"},{\"data\":[\"2\",\"2020-05-28 14:05:12\",\"甘草片\",\"\",\"\",\"甘草片\",\"\",\"\",\"0\",\"\",\"\",\"0.0893\",\"41.99\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855255\"},{\"data\":[\"3\",\"2020-05-28 14:05:12\",\"制川乌\",\"\",\"\",\"制川乌\",\"\",\"\",\"0\",\"\",\"\",\"0.2125\",\"70.02\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855256\"},{\"data\":[\"4\",\"2020-05-28 14:05:12\",\"秦艽\",\"\",\"\",\"秦艽\",\"\",\"\",\"0\",\"\",\"\",\"0.5375\",\"70.01\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855257\"},{\"data\":[\"5\",\"2020-05-28 14:05:12\",\"海风藤\",\"\",\"\",\"海风藤\",\"\",\"\",\"0\",\"\",\"\",\"0.075\",\"105.07\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855258\"},{\"data\":[\"6\",\"2020-05-28 14:05:12\",\"桑寄生\",\"\",\"\",\"桑寄生\",\"\",\"\",\"0\",\"\",\"\",\"0.0606\",\"105.12\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855259\"},{\"data\":[\"7\",\"2020-05-28 14:05:12\",\"烫狗脊\",\"\",\"\",\"烫狗脊\",\"\",\"\",\"0\",\"\",\"\",\"0.0288\",\"104.86\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855260\"},{\"data\":[\"8\",\"2020-05-28 14:05:12\",\"桑枝\",\"\",\"\",\"桑枝\",\"\",\"\",\"0\",\"\",\"\",\"0.04\",\"140\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855261\"},{\"data\":[\"9\",\"2020-05-28 14:05:12\",\"红花\",\"\",\"\",\"红花\",\"\",\"\",\"0\",\"\",\"\",\"0.3163\",\"139.99\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855262\"},{\"data\":[\"10\",\"2020-05-28 14:05:12\",\"威灵仙\",\"\",\"\",\"威灵仙\",\"\",\"\",\"0\",\"\",\"\",\"0.1588\",\"139.99\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855263\"},{\"data\":[\"11\",\"2020-05-28 14:05:12\",\"桂枝\",\"\",\"\",\"桂枝\",\"\",\"\",\"0\",\"\",\"\",\"0.0247\",\"140.08\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855264\"},{\"data\":[\"12\",\"2020-05-28 14:05:12\",\"赤芍\",\"\",\"\",\"赤芍\",\"\",\"\",\"0\",\"\",\"\",\"0.1325\",\"140\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855265\"},{\"data\":[\"13\",\"2020-05-28 10:05:19\",\"甘草片\",\"\",\"\",\"甘草片\",\"\",\"\",\"0\",\"\",\"\",\"0.0893\",\"35.05\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855166\"},{\"data\":[\"14\",\"2020-05-28 10:05:19\",\"穿心莲\",\"\",\"\",\"穿心莲\",\"\",\"\",\"0\",\"\",\"\",\"0.0084\",\"70.24\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855167\"},{\"data\":[\"15\",\"2020-05-28 10:05:19\",\"泽泻\",\"\",\"\",\"泽泻\",\"\",\"\",\"0\",\"\",\"\",\"0.075\",\"70\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855171\"},{\"data\":[\"16\",\"2020-05-28 10:05:19\",\"石韦\",\"\",\"\",\"石韦\",\"\",\"\",\"0\",\"\",\"\",\"0.055\",\"70\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855173\"},{\"data\":[\"17\",\"2020-05-28 10:05:19\",\"生蒲黄\",\"\",\"\",\"生蒲黄\",\"\",\"\",\"0\",\"\",\"\",\"0.3163\",\"70\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855175\"},{\"data\":[\"18\",\"2020-05-28 10:05:19\",\"炒葶苈子\",\"\",\"\",\"炒葶苈子\",\"\",\"\",\"0\",\"\",\"\",\"0.0325\",\"70.15\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855236\"},{\"data\":[\"19\",\"2020-05-28 10:05:19\",\"覆盆子\",\"\",\"\",\"覆盆子\",\"\",\"\",\"0\",\"\",\"\",\"0.625\",\"105.01\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855237\"},{\"data\":[\"20\",\"2020-05-28 10:05:19\",\"醋三棱\",\"\",\"\",\"醋三棱\",\"\",\"\",\"0\",\"\",\"\",\"0.0625\",\"104.96\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855238\"},{\"data\":[\"21\",\"2020-05-28 10:05:19\",\"白术\",\"\",\"\",\"白术\",\"\",\"\",\"0\",\"\",\"\",\"0.1475\",\"105.02\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855239\"},{\"data\":[\"22\",\"2020-05-28 10:05:19\",\"茯苓\",\"\",\"\",\"茯苓\",\"\",\"\",\"0\",\"\",\"\",\"0.1238\",\"104.93\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855240\"},{\"data\":[\"23\",\"2020-05-28 10:05:19\",\"盐知母\",\"\",\"\",\"盐知母\",\"\",\"\",\"0\",\"\",\"\",\"0.1088\",\"104.96\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855241\"},{\"data\":[\"24\",\"2020-05-28 10:05:19\",\"醋香附\",\"\",\"\",\"醋香附\",\"\",\"\",\"0\",\"\",\"\",\"0.0688\",\"104.94\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855242\"},{\"data\":[\"25\",\"2020-05-28 10:05:19\",\"蒲公英\",\"\",\"\",\"蒲公英\",\"\",\"\",\"0\",\"\",\"\",\"0.05\",\"105\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855243\"},{\"data\":[\"26\",\"2020-05-28 10:05:19\",\"陈皮\",\"\",\"\",\"陈皮\",\"\",\"\",\"0\",\"\",\"\",\"0.0388\",\"104.9\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855244\"},{\"data\":[\"27\",\"2020-05-28 10:05:19\",\"郁金\",\"\",\"\",\"郁金\",\"\",\"\",\"0\",\"\",\"\",\"0.1238\",\"104.93\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855245\"},{\"data\":[\"28\",\"2020-05-28 10:05:19\",\"醋青皮\",\"\",\"\",\"醋青皮\",\"\",\"\",\"0\",\"\",\"\",\"0.0289\",\"104.84\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855246\"},{\"data\":[\"29\",\"2020-05-28 10:05:19\",\"酒萸肉\",\"\",\"\",\"酒萸肉\",\"\",\"\",\"0\",\"\",\"\",\"0.1475\",\"105.02\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855247\"},{\"data\":[\"30\",\"2020-05-28 10:05:19\",\"党参片\",\"\",\"\",\"党参片\",\"\",\"\",\"0\",\"\",\"\",\"0.3375\",\"140\",\"甲类\",\"主要诊断\",\"\",\"\",\"\"],\"id\":\"86855248\"}]}\r\n" + 
		  		"";
				  
		  JsonNode node = new ObjectMapper().readTree(json);
		  JsonNode rows = node.get("rows");
		  for (JsonNode jsonNode : rows) {
			  
			JsonNode data = jsonNode.get("data");
			System.out.println(data);
//			System.out.println("index="+data.get(0)+",checkbox="+data.get(1)+",code="+data.get(2)+",id="+data.get(3)+",name="+data.get(4)+",hospital="+data.get(5)+",diease="+data.get(6)+",doctor="+data.get(7)+",flag="+data.get(8)+",date="+data.get(9));
//			System.out.println("id="+jsonNode.get("id"));
		}
		  
		  
		  
		  
	}	
	
	public void readjson(){
		String json = "{\"aggValues\":[],\"page\":{\"currentPage\":1,\"pageRecords\":200,\"totalPages\":282,\"totalRecords\":56343},\"rows\":[{\"data\":[\"1\",\"0\",\"000000011669939-1000027\",\"610**************5\",\"党**\",\"铜川市人民医院\",\"结节性甲状腺肿\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878367\"},{\"data\":[\"2\",\"0\",\"000000011659821-1000027\",\"610**************5\",\"郝**\",\"铜川市人民医院\",\"冠状动脉粥样硬化性心脏病\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879457\"},{\"data\":[\"3\",\"0\",\"000000011682980-1000016\",\"610**************X\",\"尚**\",\"铜川市人民医院（南院）\",\"2型糖尿病性神经炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879450\"},{\"data\":[\"4\",\"0\",\"000000011645211-1000028\",\"610**************6\",\"李**\",\"铜川矿务局中心医院\",\"冠状动脉粥样硬化性心脏病\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879449\"},{\"data\":[\"5\",\"0\",\"000000011732668-1000028\",\"610**************2\",\"吴**\",\"铜川矿务局中心医院\",\"支气管肺炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879424\"},{\"data\":[\"6\",\"0\",\"000000011643038-1000027\",\"410**************5\",\"席**\",\"铜川市人民医院\",\"子宫平滑肌瘤\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879408\"},{\"data\":[\"7\",\"0\",\"000000011652846-1000028\",\"610**************7\",\"康**\",\"铜川矿务局中心医院\",\"非胰岛素依赖型糖尿病不伴有并发症\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879217\"},{\"data\":[\"8\",\"0\",\"000000011607976-1000084\",\"610**************7\",\"刘**\",\"陕西省中医院\",\"冠状动脉粥样硬化性心脏病\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879213\"},{\"data\":[\"9\",\"0\",\"000000011706614-1000028\",\"610**************2\",\"郭**\",\"铜川矿务局中心医院\",\"神经根型颈椎病\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879696\"},{\"data\":[\"10\",\"0\",\"000000011655316-1000027\",\"610**************1\",\"王**\",\"铜川市人民医院\",\"肺炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879693\"},{\"data\":[\"11\",\"0\",\"000000011660372-1000027\",\"610**************1\",\"梁**\",\"铜川市人民医院\",\"高血压3级\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879689\"},{\"data\":[\"12\",\"0\",\"000000011672000-1000028\",\"610**************1\",\"段**\",\"铜川矿务局中心医院\",\"急性支气管炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879683\"},{\"data\":[\"13\",\"0\",\"000000011727046-1000027\",\"610**************6\",\"董**\",\"铜川市人民医院\",\"慢性肾炎综合征\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879198\"},{\"data\":[\"14\",\"0\",\"000000011660318-1000028\",\"610**************3\",\"王**\",\"铜川矿务局中心医院\",\"高血压3级\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879194\"},{\"data\":[\"15\",\"0\",\"000000011650538-1000099\",\"610**************8\",\"周**\",\"延安大学咸阳医院\",\"短暂性脑缺血\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879187\"},{\"data\":[\"16\",\"0\",\"000000011673820-1000016\",\"610**************3\",\"姚**\",\"铜川市人民医院（南院）\",\"重症肌无力\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879184\"},{\"data\":[\"17\",\"0\",\"000000011671161-1000027\",\"610**************7\",\"藏**\",\"铜川市人民医院\",\"脑膜肿瘤\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879678\"},{\"data\":[\"18\",\"0\",\"000000011554381-1000028\",\"610**************8\",\"雷**\",\"铜川矿务局中心医院\",\"肺炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879670\"},{\"data\":[\"19\",\"0\",\"000000011713966-1000016\",\"610**************6\",\"孙**\",\"铜川市人民医院（南院）\",\"腹泻\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879668\"},{\"data\":[\"20\",\"0\",\"000000011733161-1000028\",\"610**************2\",\"孙**\",\"铜川矿务局中心医院\",\"出生窒息\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879658\"},{\"data\":[\"21\",\"0\",\"000000011710526-1000028\",\"610**************X\",\"王**\",\"铜川矿务局中心医院\",\"高血压3级\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879649\"},{\"data\":[\"22\",\"0\",\"000000011677877-1000054\",\"610**************6\",\"马**\",\"铜川市职业病防治院\",\"冠状动脉粥样硬化性心脏病\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879644\"},{\"data\":[\"23\",\"0\",\"000000011653309-1000027\",\"610**************1\",\"秦**\",\"铜川市人民医院\",\"多囊肾\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879634\"},{\"data\":[\"24\",\"0\",\"000000011665753-1000028\",\"610**************1\",\"白**\",\"铜川矿务局中心医院\",\"晕厥和虚脱\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879628\"},{\"data\":[\"25\",\"0\",\"000000011607988-1000084\",\"610**************3\",\"尹**\",\"陕西省中医院\",\"冠状动脉粥样硬化性心脏病\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879627\"},{\"data\":[\"26\",\"0\",\"000000011670773-1000028\",\"610**************0\",\"李**\",\"铜川矿务局中心医院\",\"冠状动脉粥样硬化性心脏病\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879624\"},{\"data\":[\"27\",\"0\",\"000000011645146-1000027\",\"610**************0\",\"王**\",\"铜川市人民医院\",\"脑内出血\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879596\"},{\"data\":[\"28\",\"0\",\"000000011729880-1000004\",\"610**************6\",\"高**\",\"铜川市中医医院\",\"冠状动脉粥样硬化性心脏病\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879529\"},{\"data\":[\"29\",\"0\",\"000000011650392-1000130\",\"610**************0\",\"梁**\",\"北京中医药大学孙思邈医院\",\"支气管肺炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879506\"},{\"data\":[\"30\",\"0\",\"000000011671315-1000027\",\"610**************0\",\"韦**\",\"铜川市人民医院\",\"头晕和眩晕\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878714\"},{\"data\":[\"31\",\"0\",\"000000011710252-1000027\",\"610**************1\",\"吉**\",\"铜川市人民医院\",\"骨盆骨折\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878614\"},{\"data\":[\"32\",\"0\",\"000000011694672-1000028\",\"610**************X\",\"赵**\",\"铜川矿务局中心医院\",\"支气管肺炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879456\"},{\"data\":[\"33\",\"0\",\"000000011626628-1000007\",\"610**************4\",\"焦**\",\"耀州区人民医院\",\"大脑动脉栓塞引起的脑梗死\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879444\"},{\"data\":[\"34\",\"0\",\"000000011605470-1000126\",\"610**************X\",\"韩**\",\"孙思邈老年康复医院\",\"非胰岛素依赖型糖尿病不伴有并发症\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879434\"},{\"data\":[\"35\",\"0\",\"000000011662291-1000081\",\"610**************5\",\"周**\",\"铜川市矿务局机关卫生院\",\"冠状动脉粥样硬化性心脏病\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878532\"},{\"data\":[\"36\",\"0\",\"000000011653300-1000027\",\"610**************0\",\"赵**\",\"铜川市人民医院\",\"前列腺增生\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878511\"},{\"data\":[\"37\",\"0\",\"000000011679069-1000081\",\"610**************X\",\"展**\",\"铜川市矿务局机关卫生院\",\"脑梗死\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878401\"},{\"data\":[\"38\",\"0\",\"000000011653255-1000077\",\"610**************0\",\"姚**\",\"铜川矿务局煤机医院\",\"脑梗死\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878395\"},{\"data\":[\"39\",\"0\",\"000000011709838-1000028\",\"610**************9\",\"谢**\",\"铜川矿务局中心医院\",\"产褥期泌尿系感染\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878380\"},{\"data\":[\"40\",\"0\",\"000000011651702-1000091\",\"610**************7\",\"田**\",\"铜川市耀州区同济医院有限公司\",\"肺炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878379\"},{\"data\":[\"41\",\"0\",\"000000011650660-1000030\",\"610**************3\",\"王**\",\"耀县水泥厂职工医院\",\"冠状动脉粥样硬化性心脏病\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878363\"},{\"data\":[\"42\",\"0\",\"000000011671278-1000087\",\"610**************6\",\"贠**\",\"长安医院\",\"冠状动脉粥样硬化性心脏病\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878344\"},{\"data\":[\"43\",\"0\",\"000000011662209-1000030\",\"610**************4\",\"宋**\",\"耀县水泥厂职工医院\",\"急性气管炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878339\"},{\"data\":[\"44\",\"0\",\"000000011254765-1000026\",\"610**************8\",\"宋**\",\"矿务局精神病医院\",\"精神分裂症\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878337\"},{\"data\":[\"45\",\"0\",\"000000011580220-1000027\",\"610**************4\",\"路**\",\"铜川市人民医院\",\"脑内出血\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878334\"},{\"data\":[\"46\",\"0\",\"000000011645413-1000130\",\"610**************9\",\"宋**\",\"北京中医药大学孙思邈医院\",\"类风湿性关节炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878323\"},{\"data\":[\"47\",\"0\",\"000000011645705-1000061\",\"610**************7\",\"焦**\",\"新区咸丰路街道办事处铁诺社区卫生服务站\",\"脑梗死\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878320\"},{\"data\":[\"48\",\"0\",\"000000011646341-1000028\",\"610**************X\",\"张**\",\"铜川矿务局中心医院\",\"慢性支气管炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879195\"},{\"data\":[\"49\",\"0\",\"000000011597081-1000028\",\"610**************8\",\"宋**\",\"铜川矿务局中心医院\",\"脑梗死\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879182\"},{\"data\":[\"50\",\"0\",\"000000011702956-1000016\",\"610**************1\",\"刘**\",\"铜川市人民医院（南院）\",\"发热性惊厥\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879169\"},{\"data\":[\"51\",\"0\",\"000000011659793-1000016\",\"610**************8\",\"王**\",\"铜川市人民医院（南院）\",\"急性胰腺炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878707\"},{\"data\":[\"52\",\"0\",\"000000011656254-1000027\",\"610**************2\",\"刘**\",\"铜川市人民医院\",\"头痛\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878700\"},{\"data\":[\"53\",\"0\",\"000000011611097-1000130\",\"610**************0\",\"吕**\",\"北京中医药大学孙思邈医院\",\"慢性女性盆腔炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878493\"},{\"data\":[\"54\",\"0\",\"000000011687300-1000091\",\"610**************5\",\"杨**\",\"铜川市耀州区同济医院有限公司\",\"产褥期子宫内膜炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878655\"},{\"data\":[\"55\",\"0\",\"000000011687723-1000028\",\"610**************6\",\"巩**\",\"铜川矿务局中心医院\",\"急性支气管炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878541\"},{\"data\":[\"56\",\"0\",\"000000011675450-1000016\",\"610**************1\",\"崔**\",\"铜川市人民医院（南院）\",\"支气管肺炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878489\"},{\"data\":[\"57\",\"0\",\"000000011652894-1000028\",\"612**************1\",\"高**\",\"铜川矿务局中心医院\",\"椎-基底动脉供血不足\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878732\"},{\"data\":[\"58\",\"0\",\"000000011673960-1000084\",\"610**************4\",\"张**\",\"陕西省中医院\",\"特发性肺间质纤维化\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878726\"},{\"data\":[\"59\",\"0\",\"000000011688139-1000028\",\"610**************X\",\"翟**\",\"铜川矿务局中心医院\",\"冠状动脉粥样硬化性心脏病\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878718\"},{\"data\":[\"60\",\"0\",\"000000011673425-1000005\",\"610**************1\",\"雷**\",\"铜川市妇幼保健院\",\"支气管肺炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878702\"},{\"data\":[\"61\",\"0\",\"000000011659669-1000016\",\"610**************5\",\"董**\",\"铜川市人民医院（南院）\",\"不稳定性心绞痛\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878685\"},{\"data\":[\"62\",\"0\",\"000000011721651-1000087\",\"610**************0\",\"杜**\",\"长安医院\",\"冠状动脉粥样硬化性心脏病\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878677\"},{\"data\":[\"63\",\"0\",\"000000011671587-1000099\",\"610**************7\",\"张**\",\"延安大学咸阳医院\",\"眩晕综合征\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878670\"},{\"data\":[\"64\",\"0\",\"000000011596812-1000027\",\"610**************5\",\"侯**\",\"铜川市人民医院\",\"慢性胃炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878612\"},{\"data\":[\"65\",\"0\",\"000000011704488-1000028\",\"610**************5\",\"任**\",\"铜川矿务局中心医院\",\"支气管肺炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878531\"},{\"data\":[\"66\",\"0\",\"000000011664610-1000030\",\"610**************0\",\"王**\",\"耀县水泥厂职工医院\",\"急性结肠炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878423\"},{\"data\":[\"67\",\"0\",\"000000011612054-1000084\",\"610**************1\",\"王**\",\"陕西省中医院\",\"慢性支气管炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878409\"},{\"data\":[\"68\",\"0\",\"000000011655549-1000016\",\"610**************7\",\"赵**\",\"铜川市人民医院（南院）\",\"脑梗死\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878382\"},{\"data\":[\"69\",\"0\",\"000000011662821-1000077\",\"610**************0\",\"苏**\",\"铜川矿务局煤机医院\",\"高血压2级\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878340\"},{\"data\":[\"70\",\"0\",\"000000011484172-1000028\",\"610**************4\",\"郑**\",\"铜川矿务局中心医院\",\"脑出血个人史\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879664\"},{\"data\":[\"71\",\"0\",\"000000011602096-1000028\",\"610**************2\",\"贾**\",\"铜川矿务局中心医院\",\"脑干梗塞\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879657\"},{\"data\":[\"72\",\"0\",\"000000011734320-1000027\",\"610**************8\",\"吴**\",\"铜川市人民医院\",\"肺炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879651\"},{\"data\":[\"73\",\"0\",\"000000011646270-1000016\",\"412**************9\",\"陈**\",\"铜川市人民医院（南院）\",\"支气管哮喘,非危重\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879650\"},{\"data\":[\"74\",\"0\",\"000000011719939-1000027\",\"610**************7\",\"赵**\",\"铜川市人民医院\",\"支气管或肺恶性肿瘤\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879646\"},{\"data\":[\"75\",\"0\",\"000000011683070-1000016\",\"610**************8\",\"张**\",\"铜川市人民医院（南院）\",\"非器质性失眠症\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879629\"},{\"data\":[\"76\",\"0\",\"000000011674445-1000028\",\"610**************5\",\"段**\",\"铜川矿务局中心医院\",\"冠状动脉粥样硬化性心脏病\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879621\"},{\"data\":[\"77\",\"0\",\"000000011703494-1000020\",\"610**************5\",\"刘**\",\"宜君县中医医院\",\"慢性阻塞性肺病伴有急性加重\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879611\"},{\"data\":[\"78\",\"0\",\"000000011656498-1000099\",\"610**************7\",\"张**\",\"延安大学咸阳医院\",\"多发性脑梗塞\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879606\"},{\"data\":[\"79\",\"0\",\"000000011678141-1000130\",\"610**************3\",\"孙**\",\"北京中医药大学孙思邈医院\",\"心血管性神经官能症\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879603\"},{\"data\":[\"80\",\"0\",\"000000011660657-1000027\",\"612**************X\",\"杨**\",\"铜川市人民医院\",\"慢性胃炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879593\"},{\"data\":[\"81\",\"0\",\"000000011662496-1000051\",\"610**************4\",\"石**\",\"王益区红旗街道办事处川口社区卫生服务中心\",\"原发性双侧膝关节病\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879516\"},{\"data\":[\"82\",\"0\",\"000000011650197-1000005\",\"610**************8\",\"王**\",\"铜川市妇幼保健院\",\"包皮龟头炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879487\"},{\"data\":[\"83\",\"0\",\"000000011665920-1000012\",\"610**************8\",\"贠**\",\"宜君县人民医院\",\"高血压1级\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878730\"},{\"data\":[\"84\",\"0\",\"000000011649547-1000004\",\"610**************9\",\"程**\",\"铜川市中医医院\",\"面神经炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878725\"},{\"data\":[\"85\",\"0\",\"000000011683580-1000130\",\"610**************6\",\"杨**\",\"北京中医药大学孙思邈医院\",\"慢性胃炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878710\"},{\"data\":[\"86\",\"0\",\"000000011618631-1000027\",\"610**************5\",\"申**\",\"铜川市人民医院\",\"冠状动脉粥样硬化性心脏病\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878706\"},{\"data\":[\"87\",\"0\",\"000000011642918-1000028\",\"411**************X\",\"宋**\",\"铜川矿务局中心医院\",\"冠状动脉粥样硬化性心脏病\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878698\"},{\"data\":[\"88\",\"0\",\"000000011661811-1000028\",\"610**************2\",\"闫**\",\"铜川矿务局中心医院\",\"非胰岛素依赖型糖尿病不伴有并发症\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878676\"},{\"data\":[\"89\",\"0\",\"000000011673902-1000028\",\"610**************1\",\"路**\",\"铜川矿务局中心医院\",\"非胰岛素依赖型糖尿病不伴有并发症\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879439\"},{\"data\":[\"90\",\"0\",\"000000011671299-1000051\",\"610**************4\",\"王**\",\"王益区红旗街道办事处川口社区卫生服务中心\",\"急性支气管炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879412\"},{\"data\":[\"91\",\"0\",\"000000011706661-1000027\",\"610**************1\",\"郭**\",\"铜川市人民医院\",\"脑梗死\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879409\"},{\"data\":[\"92\",\"0\",\"000000011651263-1000099\",\"610**************3\",\"侯**\",\"延安大学咸阳医院\",\"脑梗死\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879407\"},{\"data\":[\"93\",\"0\",\"000000011646441-1000130\",\"610**************2\",\"郭**\",\"北京中医药大学孙思邈医院\",\"脑梗死\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878611\"},{\"data\":[\"94\",\"0\",\"000000011639495-1000004\",\"610**************X\",\"耿**\",\"铜川市中医医院\",\"肺炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878519\"},{\"data\":[\"95\",\"0\",\"000000011669667-1000016\",\"610**************7\",\"苗**\",\"铜川市人民医院（南院）\",\"非胰岛素依赖型糖尿病不伴有并发症\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878502\"},{\"data\":[\"96\",\"0\",\"000000011640123-1000130\",\"610**************3\",\"曹**\",\"北京中医药大学孙思邈医院\",\"脑梗死\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878500\"},{\"data\":[\"97\",\"0\",\"000000011622811-1000016\",\"610**************5\",\"靳**\",\"铜川市人民医院（南院）\",\"胆囊结石伴有急性胆囊炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878487\"},{\"data\":[\"98\",\"0\",\"000000011649814-1000007\",\"610**************8\",\"任**\",\"耀州区人民医院\",\"贫血,其他自身免疫性溶血性的\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878484\"},{\"data\":[\"99\",\"0\",\"000000011695104-1000090\",\"610**************6\",\"文**\",\"铜川市新区秦岭社区卫生服务中心\",\"睑板腺囊肿\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878482\"},{\"data\":[\"100\",\"0\",\"000000011669809-1000013\",\"610**************6\",\"王**\",\"王益区建工路社区卫生服务站\",\"脑梗死\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878435\"},{\"data\":[\"101\",\"0\",\"000000011263863-1000026\",\"610**************6\",\"昝**\",\"矿务局精神病医院\",\"精神分裂症\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878416\"},{\"data\":[\"102\",\"0\",\"000000011668973-1000027\",\"610**************X\",\"姚**\",\"铜川市人民医院\",\"良性阵发性眩晕\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878392\"},{\"data\":[\"103\",\"0\",\"000000011613655-1000016\",\"610**************6\",\"王**\",\"铜川市人民医院（南院）\",\"特发性血小板减少性紫癜\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878389\"},{\"data\":[\"104\",\"0\",\"000000011664210-1000130\",\"610**************2\",\"杜**\",\"北京中医药大学孙思邈医院\",\"支气管肺炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878374\"},{\"data\":[\"105\",\"0\",\"000000011652922-1000014\",\"610**************8\",\"闫**\",\"耀州区华原医院\",\"慢性阻塞性肺病伴有急性加重\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878372\"},{\"data\":[\"106\",\"0\",\"000000011548809-1000028\",\"610**************3\",\"王**\",\"铜川矿务局中心医院\",\"肱骨干骨折\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878368\"},{\"data\":[\"107\",\"0\",\"000000011721870-1000013\",\"610**************8\",\"曾**\",\"王益区建工路社区卫生服务站\",\"脑梗死\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878360\"},{\"data\":[\"108\",\"0\",\"000000011629096-1000030\",\"610**************8\",\"范**\",\"耀县水泥厂职工医院\",\"非胰岛素依赖型糖尿病不伴有并发症\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878353\"},{\"data\":[\"109\",\"0\",\"000000011671714-1000027\",\"610**************3\",\"韩**\",\"铜川市人民医院\",\"单侧或未特指的腹股沟疝,不伴有梗阻或坏疽\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879220\"},{\"data\":[\"110\",\"0\",\"000000011707858-1000087\",\"610**************9\",\"杜**\",\"长安医院\",\"高血压2级\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879215\"},{\"data\":[\"111\",\"0\",\"000000011672691-1000051\",\"610**************4\",\"王**\",\"王益区红旗街道办事处川口社区卫生服务中心\",\"冠状动脉粥样硬化性心脏病\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879197\"},{\"data\":[\"112\",\"0\",\"000000011663853-1000126\",\"610**************2\",\"杜**\",\"孙思邈老年康复医院\",\"脑梗死\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879192\"},{\"data\":[\"113\",\"0\",\"000000011678493-1000027\",\"610**************3\",\"陈**\",\"铜川市人民医院\",\"头晕和眩晕\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879186\"},{\"data\":[\"114\",\"0\",\"000000011671870-1000037\",\"610**************2\",\"樊**\",\"耀州区下石节社区卫生服务中心\",\"脑梗死\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879180\"},{\"data\":[\"115\",\"0\",\"000000011652937-1000028\",\"610**************0\",\"李**\",\"铜川矿务局中心医院\",\"高血压3级\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879178\"},{\"data\":[\"116\",\"0\",\"000000011680665-1000028\",\"610**************9\",\"高**\",\"铜川矿务局中心医院\",\"慢性胃炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879177\"},{\"data\":[\"117\",\"0\",\"000000011640057-1000054\",\"610**************8\",\"辛**\",\"铜川市职业病防治院\",\"腰椎间盘突出\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"879173\"},{\"data\":[\"118\",\"0\",\"000000011668549-1000126\",\"610**************X\",\"魏**\",\"孙思邈老年康复医院\",\"腰椎间盘突出\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878673\"},{\"data\":[\"119\",\"0\",\"000000011643045-1000030\",\"610**************9\",\"郑**\",\"耀县水泥厂职工医院\",\"慢性胃炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878613\"},{\"data\":[\"120\",\"0\",\"000000011535786-1000016\",\"610**************2\",\"郜**\",\"铜川市人民医院（南院）\",\"慢性阻塞性肺病伴有急性加重\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878535\"},{\"data\":[\"121\",\"0\",\"000000011661173-1000027\",\"610**************1\",\"范**\",\"铜川市人民医院\",\"低钾血症\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878524\"},{\"data\":[\"122\",\"0\",\"000000011625012-1000007\",\"610**************7\",\"王**\",\"耀州区人民医院\",\"脑梗死\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878508\"},{\"data\":[\"123\",\"0\",\"000000011716617-1000016\",\"610**************1\",\"王**\",\"铜川市人民医院（南院）\",\"非器质性失眠症\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878504\"},{\"data\":[\"124\",\"0\",\"000000011647730-1000028\",\"610**************1\",\"张**\",\"铜川矿务局中心医院\",\"肺炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878394\"},{\"data\":[\"125\",\"0\",\"000000011661274-1000028\",\"610**************1\",\"唐**\",\"铜川矿务局中心医院\",\"短暂性脑缺血\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878384\"},{\"data\":[\"126\",\"0\",\"000000011662593-1000027\",\"610**************X\",\"谷**\",\"铜川市人民医院\",\"急性支气管炎\",\"-\",\"是\",\"2018-12-06\"],\"id\":\"878377\"},{\"data\":[\"127\",\"0\",\"000000011590352-1000027\",\"610**************9\",\"黄**\",\"铜川市人民医院\",\"耳聋 NOS\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879703\"},{\"data\":[\"128\",\"0\",\"000000011670215-1000130\",\"610**************3\",\"李**\",\"北京中医药大学孙思邈医院\",\"心脏神经官能症\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878645\"},{\"data\":[\"129\",\"0\",\"000000011680269-1000027\",\"610**************3\",\"惠**\",\"铜川市人民医院\",\"非霍奇金淋巴瘤\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878517\"},{\"data\":[\"130\",\"0\",\"000000011635637-1000061\",\"610**************9\",\"刘**\",\"新区咸丰路街道办事处铁诺社区卫生服务站\",\"脑梗死\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878422\"},{\"data\":[\"131\",\"0\",\"000000011654993-1000016\",\"610**************9\",\"刘**\",\"铜川市人民医院（南院）\",\"慢性阻塞性肺病伴有急性加重\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878358\"},{\"data\":[\"132\",\"0\",\"000000011599900-1000027\",\"610**************7\",\"辛**\",\"铜川市人民医院\",\"慢性肾衰竭\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878351\"},{\"data\":[\"133\",\"0\",\"000000011574708-1000102\",\"610**************7\",\"文**\",\"铜川市康骨医院\",\"半月板损伤\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878346\"},{\"data\":[\"134\",\"0\",\"000000011647563-1000028\",\"610**************0\",\"李**\",\"铜川矿务局中心医院\",\"脑梗死\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878331\"},{\"data\":[\"135\",\"0\",\"000000011610245-1000054\",\"610**************4\",\"王**\",\"铜川市职业病防治院\",\"急性胃炎\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879659\"},{\"data\":[\"136\",\"0\",\"000000011650250-1000040\",\"610**************6\",\"华**\",\"印台区城关街道办事处鑫光社区卫生服务中心\",\"高血压\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879635\"},{\"data\":[\"137\",\"0\",\"000000011599811-1000054\",\"610**************3\",\"王**\",\"铜川市职业病防治院\",\"脑梗死\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879631\"},{\"data\":[\"138\",\"0\",\"000000011706853-1000027\",\"610**************1\",\"郭**\",\"铜川市人民医院\",\"梗阻性黄疸\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879630\"},{\"data\":[\"139\",\"0\",\"000000011661608-1000028\",\"610**************5\",\"雍**\",\"铜川矿务局中心医院\",\"非胰岛素依赖型糖尿病不伴有并发症\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879618\"},{\"data\":[\"140\",\"0\",\"000000011702737-1000028\",\"610**************5\",\"于**\",\"铜川矿务局中心医院\",\"冠状动脉粥样硬化性心脏病\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879612\"},{\"data\":[\"141\",\"0\",\"000000011664814-1000028\",\"610**************9\",\"李**\",\"铜川矿务局中心医院\",\"非感染性急性肠炎\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879601\"},{\"data\":[\"142\",\"0\",\"000000011659755-1000081\",\"610**************6\",\"王**\",\"铜川市矿务局机关卫生院\",\"脑梗死\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879600\"},{\"data\":[\"143\",\"0\",\"000000011639880-1000028\",\"610**************0\",\"阎**\",\"铜川矿务局中心医院\",\"肺炎\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879598\"},{\"data\":[\"144\",\"0\",\"000000011675174-1000028\",\"610**************5\",\"芦**\",\"铜川矿务局中心医院\",\"高血压3级\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879595\"},{\"data\":[\"145\",\"0\",\"000000011640350-1000027\",\"610**************2\",\"魏**\",\"铜川市人民医院\",\"会厌囊肿\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879520\"},{\"data\":[\"146\",\"0\",\"000000011642308-1002004\",\"610**************1\",\"李**\",\"铜川康德中医医院\",\"血栓性外痔\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879507\"},{\"data\":[\"147\",\"0\",\"000000011681251-1000027\",\"610**************6\",\"王**\",\"铜川市人民医院\",\"冠状动脉粥样硬化性心脏病\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879499\"},{\"data\":[\"148\",\"0\",\"000000011645191-1000087\",\"610**************6\",\"吴**\",\"长安医院\",\"高血压3级\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879490\"},{\"data\":[\"149\",\"0\",\"000000011670371-1000027\",\"610**************3\",\"任**\",\"铜川市人民医院\",\"高血压3级\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878724\"},{\"data\":[\"150\",\"0\",\"000000011664148-1000130\",\"610**************8\",\"梁**\",\"北京中医药大学孙思邈医院\",\"甲状腺功能检查的异常结果\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878722\"},{\"data\":[\"151\",\"0\",\"000000011649786-1000028\",\"610**************7\",\"齐**\",\"铜川矿务局中心医院\",\"急性支气管炎\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878717\"},{\"data\":[\"152\",\"0\",\"000000011632398-1000028\",\"610**************4\",\"刘**\",\"铜川矿务局中心医院\",\"眩晕综合征\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878713\"},{\"data\":[\"153\",\"0\",\"000000011704931-1000016\",\"610**************4\",\"齐**\",\"铜川市人民医院（南院）\",\"泪道阻塞\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878709\"},{\"data\":[\"154\",\"0\",\"000000011679782-1000028\",\"610**************3\",\"王**\",\"铜川矿务局中心医院\",\"支气管肺炎\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879455\"},{\"data\":[\"155\",\"0\",\"000000011642293-1000056\",\"610**************8\",\"李**\",\"王益区黄堡社区卫生服务中心\",\"脑梗死\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879453\"},{\"data\":[\"156\",\"0\",\"000000011640248-1000028\",\"610**************9\",\"刘**\",\"铜川矿务局中心医院\",\"眩晕综合征\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879447\"},{\"data\":[\"157\",\"0\",\"000000011664679-1000028\",\"610**************3\",\"赵**\",\"铜川矿务局中心医院\",\"感染性发热\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879443\"},{\"data\":[\"158\",\"0\",\"000000011615954-1000004\",\"610**************6\",\"李**\",\"铜川市中医医院\",\"急性胆囊炎\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879432\"},{\"data\":[\"159\",\"0\",\"000000011602354-1000130\",\"610**************7\",\"刘**\",\"北京中医药大学孙思邈医院\",\"脑梗死\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879417\"},{\"data\":[\"160\",\"0\",\"000000011615961-1000004\",\"610**************3\",\"陈**\",\"铜川市中医医院\",\"非胰岛素依赖型糖尿病不伴有并发症\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879402\"},{\"data\":[\"161\",\"0\",\"000000011642594-1000130\",\"610**************5\",\"赵**\",\"北京中医药大学孙思邈医院\",\"冠状动脉粥样硬化性心脏病\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878646\"},{\"data\":[\"162\",\"0\",\"000000011718365-1000130\",\"610**************0\",\"何**\",\"北京中医药大学孙思邈医院\",\"头晕和眩晕\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879401\"},{\"data\":[\"163\",\"0\",\"000000011618102-1000027\",\"610**************1\",\"张**\",\"铜川市人民医院\",\"肺炎\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879400\"},{\"data\":[\"164\",\"0\",\"000000011673926-1000028\",\"610**************7\",\"周**\",\"铜川矿务局中心医院\",\"高血压3级\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879399\"},{\"data\":[\"165\",\"0\",\"000000011666245-1000079\",\"610**************0\",\"毛**\",\"王家河社区管理中心卫生所\",\"多发性脑梗塞\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878523\"},{\"data\":[\"166\",\"0\",\"000000011477005-1000084\",\"610**************X\",\"刘**\",\"陕西省中医院\",\"慢性胃炎\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878522\"},{\"data\":[\"167\",\"0\",\"000000011666258-1000079\",\"610**************9\",\"胡**\",\"王家河社区管理中心卫生所\",\"冠状动脉粥样硬化性心脏病\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878510\"},{\"data\":[\"168\",\"0\",\"000000011709678-1000028\",\"642**************3\",\"李**\",\"铜川矿务局中心医院\",\"扩张型心肌病\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878509\"},{\"data\":[\"169\",\"0\",\"000000011706048-1000016\",\"610**************4\",\"马**\",\"铜川市人民医院（南院）\",\"黄斑变性\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878433\"},{\"data\":[\"170\",\"0\",\"000000011653238-1000027\",\"610**************6\",\"时**\",\"铜川市人民医院\",\"子宫腺肌病\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878427\"},{\"data\":[\"171\",\"0\",\"000000011642598-1000028\",\"610**************X\",\"焦**\",\"铜川矿务局中心医院\",\"慢性胃炎\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878426\"},{\"data\":[\"172\",\"0\",\"000000011650483-1000087\",\"610**************0\",\"张**\",\"长安医院\",\"眩晕综合征\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878424\"},{\"data\":[\"173\",\"0\",\"000000011651991-1000016\",\"610**************4\",\"郑**\",\"铜川市人民医院（南院）\",\"脑卒中\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878415\"},{\"data\":[\"174\",\"0\",\"000000011708042-1000028\",\"610**************7\",\"曹**\",\"铜川矿务局中心医院\",\"痔\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878411\"},{\"data\":[\"175\",\"0\",\"000000011627106-1000028\",\"610**************1\",\"李**\",\"铜川矿务局中心医院\",\"前列腺增生\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878390\"},{\"data\":[\"176\",\"0\",\"000000011640761-1000130\",\"610**************4\",\"李**\",\"北京中医药大学孙思邈医院\",\"结肠息肉\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878388\"},{\"data\":[\"177\",\"0\",\"000000011655585-1000016\",\"610**************X\",\"杨**\",\"铜川市人民医院（南院）\",\"细菌性肺炎\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878385\"},{\"data\":[\"178\",\"0\",\"000000011653253-1000130\",\"610**************6\",\"阴**\",\"北京中医药大学孙思邈医院\",\"癫痫\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878383\"},{\"data\":[\"179\",\"0\",\"000000011659397-1000077\",\"610**************9\",\"张**\",\"铜川矿务局煤机医院\",\"非胰岛素依赖型糖尿病不伴有并发症\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878371\"},{\"data\":[\"180\",\"0\",\"000000011584840-1000027\",\"610**************2\",\"吴**\",\"铜川市人民医院\",\"慢性肾衰竭\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878362\"},{\"data\":[\"181\",\"0\",\"000000011678865-1000030\",\"610**************5\",\"刘**\",\"耀县水泥厂职工医院\",\"胆囊炎\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878355\"},{\"data\":[\"182\",\"0\",\"000000011659900-1000027\",\"610**************8\",\"齐**\",\"铜川市人民医院\",\"腘窝脓肿\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879227\"},{\"data\":[\"183\",\"0\",\"000000011675172-1000016\",\"610**************5\",\"杨**\",\"铜川市人民医院（南院）\",\"稳定型心绞痛\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879221\"},{\"data\":[\"184\",\"0\",\"000000011664275-1000027\",\"610**************0\",\"郭**\",\"铜川市人民医院\",\"子宫内膜息肉\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879211\"},{\"data\":[\"185\",\"0\",\"000000011671492-1000028\",\"610**************3\",\"伯**\",\"铜川矿务局中心医院\",\"肺炎\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879208\"},{\"data\":[\"186\",\"0\",\"000000011688742-1000091\",\"610**************2\",\"王**\",\"铜川市耀州区同济医院有限公司\",\"慢性女性盆腔炎\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879206\"},{\"data\":[\"187\",\"0\",\"000000011651406-1000005\",\"610**************3\",\"杨**\",\"铜川市妇幼保健院\",\"急性上呼吸道感染\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879174\"},{\"data\":[\"188\",\"0\",\"000000011688192-1000028\",\"610**************0\",\"田**\",\"铜川矿务局中心医院\",\"腰椎间盘突出\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879171\"},{\"data\":[\"189\",\"0\",\"000000011593307-1000054\",\"610**************1\",\"郭**\",\"铜川市职业病防治院\",\"胃溃疡\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"879168\"},{\"data\":[\"190\",\"0\",\"000000011660005-1000028\",\"610**************7\",\"张**\",\"铜川矿务局中心医院\",\"非胰岛素依赖型糖尿病不伴有并发症\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878721\"},{\"data\":[\"191\",\"0\",\"000000011662544-1000050\",\"610**************3\",\"黄**\",\"王益区红旗街道办事处翠溪社区卫生服务中心\",\"冠状动脉粥样硬化性心脏病\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878712\"},{\"data\":[\"192\",\"0\",\"000000011670114-1000077\",\"610**************2\",\"夏**\",\"铜川矿务局煤机医院\",\"脑梗死\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878704\"},{\"data\":[\"193\",\"0\",\"000000011677895-1000117\",\"610**************7\",\"赵**\",\"印台区同官路颈肩腰腿痛医院\",\"腰椎间盘突出\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878686\"},{\"data\":[\"194\",\"0\",\"000000011592518-1000027\",\"610**************9\",\"许**\",\"铜川市人民医院\",\"肾盂积水\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878678\"},{\"data\":[\"195\",\"0\",\"000000011656362-1000028\",\"610**************8\",\"张**\",\"铜川矿务局中心医院\",\"眩晕综合征\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878491\"},{\"data\":[\"196\",\"0\",\"000000011643886-1000027\",\"610**************9\",\"赵**\",\"铜川市人民医院\",\"腔隙性脑梗死\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878434\"},{\"data\":[\"197\",\"0\",\"000000011683398-1000087\",\"610**************1\",\"张**\",\"长安医院\",\"结肠息肉\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878420\"},{\"data\":[\"198\",\"0\",\"000000011641950-1000028\",\"610**************X\",\"卫**\",\"铜川矿务局中心医院\",\"前列腺充血和出血\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878404\"},{\"data\":[\"199\",\"0\",\"000000011646288-1000051\",\"610**************3\",\"袁**\",\"王益区红旗街道办事处川口社区卫生服务中心\",\"脑梗死\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878375\"},{\"data\":[\"200\",\"0\",\"000000011664211-1000016\",\"610**************4\",\"李**\",\"铜川市人民医院（南院）\",\"偏头痛\",\"-\",\"是\",\"2018-12-05\"],\"id\":\"878343\"}]}";
		 
		
	}
	
}
