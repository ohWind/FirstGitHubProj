package cn.jbit.output;
import java.util.Scanner;
public class Class_9_ChiHuoLianMeng {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int no=1;  //  判定是否终止循环
		
		String[] names = new String[4]; // 订餐人姓名
		String[] dishMegs = new String[4]; // 订餐信息，包含菜名及份数
		int[] times = new int[4]; // 送餐时间
		String[] addresses = new String[4]; // 送餐地址
		int[] states = new int[4]; // 订餐状态
		double[] sumPrices = new double[4]; // 订单总额
		
		int[] isPraise = new int[4]; //点赞状态：0为还未点赞，1为已点赞
		
		//初始化订餐信息
		names[0] = "李青";
		dishMegs[0] = "鱼香肉丝 1份";
		times[0] = 13;
		addresses[0] = "朝阳路13号";
		states[0] = 0;
		sumPrices[0] = 20.0;
		isPraise[0] = 0;
		//初始化订餐信息
		names[1] = "李青";
		dishMegs[1] = "鱼香肉丝 2份";
		times[1] = 13;
		addresses[1] = "朝阳路13号";
		states[1] = 0;
		sumPrices[1] = 40.0;
		isPraise[0] = 0;
		
		//初始化菜单信息
		String[] dishNames = {"红烧带鱼","鱼香肉丝","时令鲜疏"};  //菜名
		double[] prices = { 38.0, 20.0, 10.0}; //单价
		int[] praiseNum = new int[3]; //点赞数
		
		do{
			/*****系统主页*****/
			System.out.println("欢迎使用“吃货联盟订餐系统”");
			System.out.println("************************");
			int lines[] = new int[]{1,2,3,4,5,6};
			String[] str ={"我要订餐","查看餐袋","签收订单","删除订单","我要点赞","退出系统"};
			for (int i=0;i<lines.length;i++){
				System.out.println(lines[i]+"、"+str[i]);
			}
			System.out.println("************************");
			
			String isContinue="y";    // 判断是否继续
			boolean isExit =false;  //  判定是否返回上一页面
			do{
				
				System.out.println("请选择：");
				if (input.hasNextInt()==true){
					int num = input.nextInt();
					switch(num){
					    case 1:
					    	do{
					    		System.out.println("****"+str[num-1]+"****");
						    	/****菜单信息****/
						    	System.out.println("************************");
								System.out.println("序号\t菜名\t\t单价\t点赞数");
								for (int i=0;i<dishNames.length;i++){
									System.out.println(lines[i]+"\t"+dishNames[i]+"\t\t"+prices[i]+"\t"+praiseNum[i]);
								}
								System.out.println("************************");
					    	
								int chooseDish=0,number=0;     //菜名、份数
								int time=0;                    //送餐时间
								String address="";             //送餐地址
								
								System.out.println("请输入订餐人姓名：");
								String name = input.next();
								
								do{
									System.out.println("请选择您要点的菜品编号：");
									if (input.hasNextInt()){
										chooseDish = input.nextInt(); //选择菜品编号
										if(chooseDish<=0||chooseDish>dishNames.length){
											System.out.println("输入错误，请重新输入！");
										}
									}else{
										System.out.println("输入错误，请重新输入！");
										input.next();
									}
								}while(chooseDish<=0||chooseDish>dishNames.length);
								
								do{
									System.out.println("请选择您需要的菜品份数(1-10份之间)：");
									if (input.hasNextInt()==true){
										number = input.nextInt(); //选择菜品份数
										if(number<=0 || number>10){
											System.out.println("输入错误，请重新输入！");
										}
									}else{
										System.out.println("输入错误，请重新输入！");
										input.next();
									}
								}while(number<=0 || number>10);
								
								do{
									System.out.println("请选择送餐时间（12-18点之间的整数）：");
									if (input.hasNextInt()==true){
										time = input.nextInt(); //送餐时间
										if (!(time>=12&&time<=18)){
											System.out.println("输入错误，请重新输入！");
										}
									}else{
										System.out.println("输入错误，请重新输入！");
										input.next();
										continue;
									}
								}while(time<12 || time>18);
								
								System.out.println("请选择送餐地址：");
								address = input.next();     //送餐地址
								
								String dishMeg = dishNames[chooseDish-1]+" "+number+"份";//订餐信息
								double sumPrice = prices[chooseDish-1]*number;       //订单金额
								int wayPrice = 5;                                //送餐费用；满35免费送餐
								if (sumPrice>=35){
									wayPrice = 0;
								}
								int count =0;           //计数
								/****将订餐信息保存****/
								for (int j=0;j<names.length;j++){
									if(names[j]==null){
										names[j]=name;
										dishMegs[j]=dishMeg;
										times[j]=time;
										addresses[j]=address;
										sumPrices[j]=sumPrice;
										break;
									}
									count++;
								}
								if(count==names.length){
									System.out.println("对不起，您对餐袋已满,订餐失败！");
									no=1;        //跳出上一循环
									break;
								}
								System.out.println("订餐成功！");
								//打印订餐信息
								System.out.println("订餐人："+name+"\n餐品信息："+dishMeg+"\n送餐时间："
											+time+"点\n送餐地址："+address+"\n订单金额："+sumPrice+"元\t送餐费用："+wayPrice+"元");
								
								System.out.println("是否继续点餐(输入y继续，输入0返回上一页面，输入其它退出系统)：");
								isContinue =input.next();
								if("y".equals(isContinue)){
									continue;
								}else if("0".equals(isContinue)){
									no=1;   //跳出上一循环
									break;
								}else {
									no=1;   //跳出上一循环
									isExit = true;     //跳出整个循环
									break;
								}
							}while("y".equals(isContinue));
							
					    	break;
					    case 2:
					    	System.out.println("****"+str[num-1]+"****");
					    	/****订餐信息****/
					    	System.out.println("序号"+"\t"+"订餐人"+"\t"+"餐品信息"+"\t\t"+"送餐时间"+"\t"+"送餐地址"
					    				+"\t\t"+"订单状态"+"\t"+"总金额");
					    	for (int i=0;i<names.length;i++){
					    		if (names[i]!=null){
					    			String state=states[i]==0?"已预订":"已签收";
					    			String date=times[i]+"点";
					    			String sumPrice=sumPrices[i]+"元";
					    			System.out.println(lines[i]+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+date+"\t"
					    						+addresses[i]+"\t"+state+"\t"+sumPrice);
					    		}
					    		
					    	}
					    	no=1;  //退出上一循环
					    	break;
					    case 3:
					    	System.out.println("****"+str[num-1]+"****");
					    	int number =0;      //签收订单数量
					    	//显示订单信息
					    	System.out.println("序号"+"\t"+"订餐人"+"\t"+"餐品信息"+"\t\t"+"送餐时间"+"\t"+"送餐地址"
					    				+"\t\t"+"订单状态"+"\t"+"总金额");
					    	for (int i=0;i<names.length;i++){
					    		if (names[i]!=null){
					    			String state=states[i]==0?"已预订":"已签收";
					    			String date=times[i]+"点";
					    			String sumPrice=sumPrices[i]+"元";
					    			System.out.println(lines[i]+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+date+"\t"
					    						+addresses[i]+"\t"+state+"\t"+sumPrice);
					    			
					    			if(states[i]==0){         //未签收订单
						    			number++;
						    		}
					    		}
					    	}
					    	//没有已签收订单
					    	if(number==0){
					    		System.out.println("无未签收订单信息！");
			    				break;
					    	}
					    	
					    	//签收订单:
					    	for(int i=0;i<names.length;i++){       //最大可输入次数为数组长度
					    		System.out.println("请选择您要签收的订单编号：");
					    		if (input.hasNextInt()==true){
					    			number = input.nextInt();
					    			if (number>0 && number<=names.length){    //数组下标范围
					    				if(names[number-1]==null){          //订单不为空
					    					System.out.println("您选择的订单不存在！");
					    				}else if(states[number-1]==0){        //状态为未签收
						    				System.out.println("签收成功！");
											states[number-1]=1;
											break;
										}else {                             //订单为空
											System.out.println("该订单您已签收，无法再次签收！");
											break;
									    }
					    			}else{                                //超出订单编号范围
								    	System.out.println("您选择的订单不存在！");
								    }
					    		}else{               //输入不为整数
									System.out.println("请正确输入：");
									input.next();
									continue;
								}
					    	}
					    	no=1;  //退出上一循环
					    	break;
					    case 4:
					    	System.out.println("****"+str[num-1]+"****");
					    	int numb=0;
					    	/****订餐信息****/
					    	System.out.println("序号"+"\t"+"订餐人"+"\t"+"餐品信息"+"\t\t"+"送餐时间"+"\t"+"送餐地址"+"\t\t"
					    				+"订单状态"+"\t"+"总金额");
					    	for (int i=0;i<names.length;i++){
					    		if (names[i]!=null){
					    			String state=states[i]==0?"已预订":"已签收";
					    			String date=times[i]+"点";
					    			String sumPrice=sumPrices[i]+"元";
					    			System.out.println(lines[i]+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+date+"\t"
					    						+addresses[i]+"\t"+state+"\t"+sumPrice);
					    			
					    		}
					    		if(states[i]!=0){         //已签收订单
					    			numb++;
					    		}
					    		
					    	}
					    	//没有已签收订单，则无可删除信息
					    	if(numb==0){
					    		System.out.println("无可删除订单信息！");
					    		no=1;  //退出上一循环
			    				break;
					    	}
					    	//删除订单
					    	for(int j=0;j<names.length;j++){        //最大可输入次数为数组长度
					    		System.out.println("请选择您要删除的订单编号：");
					    		if (input.hasNextInt()==true){
						    		numb = input.nextInt();
						    		if(numb>=1 && numb<=names.length){       //订单数组下标范围
						    			if(names[numb-1]==null  ){        //订单不为空
						    				System.out.println("订单不存在！");
						    			}else if( states[numb-1]!=0){      //订单已签收
						    				//删除当前订单，并将编号后订单前移
						    				for(int i=numb-1;i<names.length-1;i++){  
							    				names[i]=names[i+1];
												dishMegs[i]=dishMegs[i+1];
												times[i]=times[i+1];
												addresses[i]=addresses[i+1];
												states[i]=states[i+1];
												sumPrices[i]=sumPrices[i+1];
												isPraise[i] = isPraise[i+1];
							    			}
							    			names[names.length-1]=null;
											dishMegs[names.length-1]=null;
											times[names.length-1]=0;
											addresses[names.length-1]=null;
											states[names.length-1]=0;
											sumPrices[names.length-1]=0;
											isPraise[names.length-1] = 0;
											System.out.println("订单已删除！");
							    			break;
						    			}else{              					 //订单为签收
						    				System.out.println("订单还未签收，无法删除！");
						    				break;
						    			}
						    			
						    		}else{                                  //超出订单编号范围
										System.out.println("订单不存在！");
										
										continue;
									}
						    	}else{
									System.out.println("请正确输入：");
									input.next();
									continue;
								}
					    	}
					    	no=1;  //退出上一循环
					    	break;
					    case 5:
					    	System.out.println("****"+str[num-1]+"****");
					    	/****菜单****/
					    	System.out.println("************************");
							System.out.println("序号\t菜名\t\t单价\t点赞数");
							for (int i=0;i<dishNames.length;i++){
								System.out.println(lines[i]+"\t"+dishNames[i]+"\t\t"+prices[i]+"\t"+praiseNum[i]);
							}
							
					    	//点赞
					    	for(int i=0;i<names.length;i++){      //最大可输入次数为数组长度
					    		System.out.println("请输入您要点赞的菜品编号：");
					    		if(input.hasNextInt()==true){
					    			int number2=input.nextInt();
					    			if(number2>0 && number2<=dishNames.length){
					    				int count1 = 0;     //计数
					    				int count2 = 0;     //计数
					    				//判断点赞资格：有订餐该菜品，且订单已签收,且还未点赞
					    				for(int j=0;j<names.length;j++){
					    					if(names[j]==null){      //对应编号无订单
					    						continue;
					    					}
					    					String[] s = dishMegs[j].split(" ");    //将菜品信息拆分成菜品、份数
					    					//判定是否拥有点赞资格
//					    					System.out.println(dishNames[number2-1]+" ----- "+s[0]+" ------- "+dishMegs[j]);
//					    					System.out.println(dishNames[number2-1].equals(s[0]));
					    					if(dishNames[number2-1].equals(s[0]) && states[j]==1 && isPraise[j]==0){
					    						System.out.println("点赞成功！");
							    				praiseNum[number2-1]++;
							    				isPraise[j]=1;
							    				count1++;
							    				break;
					    					}else if(dishNames[number2-1].equals(s[0]) && states[j]==1 && isPraise[j]==1){
					    						//该订单已经点赞
					    						count2++;
					    					}
					    					
					    				}
					    				if(count1!=0){    //已经点赞
					    					break;
					    				}
					    				if(count2>0){      //订单已点赞
					    					System.out.println("您已点赞，无法再次点赞！");
					    				}else{
					    					System.out.println("您未订购（或未签收）此菜品，无法点赞！");
					    				}
					    				break;
					    				
					    			}else{
					    				System.out.println("无此订单，请重新输入：");
					    				continue;
					    			}
					    		}else{
					    			System.out.println("请正确输入：");
									input.next();
									continue;
					    		}
					    		
					    	}
					    	no=1;  //退出上一循环
					    	break;
					    case 6:	
					    	no=1;   //退出上一循环
					    	isExit =true;
					        break;
					    default:
					    	no=0;      //当前循环条件，继续当前循环
					    	System.out.println("输入错误，请重新输入！");
					    	continue;
					}
					
				
				}else{
					no=0;     //当前循环条件，继续当前循环
					System.out.println("输入错误，请重新输入！");
					input.next();
				}
				
			}while(no==0);
			
			if (isExit){
				System.out.println("谢谢使用，欢迎下次光临！");
				break;
			}
			
			if(!"0".equals(isContinue)){
				System.out.println("输入0返回上一页面，输入其它退出系统：");
				isContinue =input.next();
				if(!"0".equals(isContinue)){
					System.out.println("谢谢使用，欢迎下次光临！");
			    	break;
				}
			}
			
		}while(no!=0);
		System.out.println("程序结束！");

	}

}
