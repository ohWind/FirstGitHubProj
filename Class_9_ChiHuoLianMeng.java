package cn.jbit.output;
import java.util.Scanner;
public class Class_9_ChiHuoLianMeng {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int no=1;  //  �ж��Ƿ���ֹѭ��
		
		String[] names = new String[4]; // ����������
		String[] dishMegs = new String[4]; // ������Ϣ����������������
		int[] times = new int[4]; // �Ͳ�ʱ��
		String[] addresses = new String[4]; // �Ͳ͵�ַ
		int[] states = new int[4]; // ����״̬
		double[] sumPrices = new double[4]; // �����ܶ�
		
		int[] isPraise = new int[4]; //����״̬��0Ϊ��δ���ޣ�1Ϊ�ѵ���
		
		//��ʼ��������Ϣ
		names[0] = "����";
		dishMegs[0] = "������˿ 1��";
		times[0] = 13;
		addresses[0] = "����·13��";
		states[0] = 0;
		sumPrices[0] = 20.0;
		isPraise[0] = 0;
		//��ʼ��������Ϣ
		names[1] = "����";
		dishMegs[1] = "������˿ 2��";
		times[1] = 13;
		addresses[1] = "����·13��";
		states[1] = 0;
		sumPrices[1] = 40.0;
		isPraise[0] = 0;
		
		//��ʼ���˵���Ϣ
		String[] dishNames = {"���մ���","������˿","ʱ������"};  //����
		double[] prices = { 38.0, 20.0, 10.0}; //����
		int[] praiseNum = new int[3]; //������
		
		do{
			/*****ϵͳ��ҳ*****/
			System.out.println("��ӭʹ�á��Ի����˶���ϵͳ��");
			System.out.println("************************");
			int lines[] = new int[]{1,2,3,4,5,6};
			String[] str ={"��Ҫ����","�鿴�ʹ�","ǩ�ն���","ɾ������","��Ҫ����","�˳�ϵͳ"};
			for (int i=0;i<lines.length;i++){
				System.out.println(lines[i]+"��"+str[i]);
			}
			System.out.println("************************");
			
			String isContinue="y";    // �ж��Ƿ����
			boolean isExit =false;  //  �ж��Ƿ񷵻���һҳ��
			do{
				
				System.out.println("��ѡ��");
				if (input.hasNextInt()==true){
					int num = input.nextInt();
					switch(num){
					    case 1:
					    	do{
					    		System.out.println("****"+str[num-1]+"****");
						    	/****�˵���Ϣ****/
						    	System.out.println("************************");
								System.out.println("���\t����\t\t����\t������");
								for (int i=0;i<dishNames.length;i++){
									System.out.println(lines[i]+"\t"+dishNames[i]+"\t\t"+prices[i]+"\t"+praiseNum[i]);
								}
								System.out.println("************************");
					    	
								int chooseDish=0,number=0;     //����������
								int time=0;                    //�Ͳ�ʱ��
								String address="";             //�Ͳ͵�ַ
								
								System.out.println("�����붩����������");
								String name = input.next();
								
								do{
									System.out.println("��ѡ����Ҫ��Ĳ�Ʒ��ţ�");
									if (input.hasNextInt()){
										chooseDish = input.nextInt(); //ѡ���Ʒ���
										if(chooseDish<=0||chooseDish>dishNames.length){
											System.out.println("����������������룡");
										}
									}else{
										System.out.println("����������������룡");
										input.next();
									}
								}while(chooseDish<=0||chooseDish>dishNames.length);
								
								do{
									System.out.println("��ѡ������Ҫ�Ĳ�Ʒ����(1-10��֮��)��");
									if (input.hasNextInt()==true){
										number = input.nextInt(); //ѡ���Ʒ����
										if(number<=0 || number>10){
											System.out.println("����������������룡");
										}
									}else{
										System.out.println("����������������룡");
										input.next();
									}
								}while(number<=0 || number>10);
								
								do{
									System.out.println("��ѡ���Ͳ�ʱ�䣨12-18��֮�����������");
									if (input.hasNextInt()==true){
										time = input.nextInt(); //�Ͳ�ʱ��
										if (!(time>=12&&time<=18)){
											System.out.println("����������������룡");
										}
									}else{
										System.out.println("����������������룡");
										input.next();
										continue;
									}
								}while(time<12 || time>18);
								
								System.out.println("��ѡ���Ͳ͵�ַ��");
								address = input.next();     //�Ͳ͵�ַ
								
								String dishMeg = dishNames[chooseDish-1]+" "+number+"��";//������Ϣ
								double sumPrice = prices[chooseDish-1]*number;       //�������
								int wayPrice = 5;                                //�Ͳͷ��ã���35����Ͳ�
								if (sumPrice>=35){
									wayPrice = 0;
								}
								int count =0;           //����
								/****��������Ϣ����****/
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
									System.out.println("�Բ������Բʹ�����,����ʧ�ܣ�");
									no=1;        //������һѭ��
									break;
								}
								System.out.println("���ͳɹ���");
								//��ӡ������Ϣ
								System.out.println("�����ˣ�"+name+"\n��Ʒ��Ϣ��"+dishMeg+"\n�Ͳ�ʱ�䣺"
											+time+"��\n�Ͳ͵�ַ��"+address+"\n������"+sumPrice+"Ԫ\t�Ͳͷ��ã�"+wayPrice+"Ԫ");
								
								System.out.println("�Ƿ�������(����y����������0������һҳ�棬���������˳�ϵͳ)��");
								isContinue =input.next();
								if("y".equals(isContinue)){
									continue;
								}else if("0".equals(isContinue)){
									no=1;   //������һѭ��
									break;
								}else {
									no=1;   //������һѭ��
									isExit = true;     //��������ѭ��
									break;
								}
							}while("y".equals(isContinue));
							
					    	break;
					    case 2:
					    	System.out.println("****"+str[num-1]+"****");
					    	/****������Ϣ****/
					    	System.out.println("���"+"\t"+"������"+"\t"+"��Ʒ��Ϣ"+"\t\t"+"�Ͳ�ʱ��"+"\t"+"�Ͳ͵�ַ"
					    				+"\t\t"+"����״̬"+"\t"+"�ܽ��");
					    	for (int i=0;i<names.length;i++){
					    		if (names[i]!=null){
					    			String state=states[i]==0?"��Ԥ��":"��ǩ��";
					    			String date=times[i]+"��";
					    			String sumPrice=sumPrices[i]+"Ԫ";
					    			System.out.println(lines[i]+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+date+"\t"
					    						+addresses[i]+"\t"+state+"\t"+sumPrice);
					    		}
					    		
					    	}
					    	no=1;  //�˳���һѭ��
					    	break;
					    case 3:
					    	System.out.println("****"+str[num-1]+"****");
					    	int number =0;      //ǩ�ն�������
					    	//��ʾ������Ϣ
					    	System.out.println("���"+"\t"+"������"+"\t"+"��Ʒ��Ϣ"+"\t\t"+"�Ͳ�ʱ��"+"\t"+"�Ͳ͵�ַ"
					    				+"\t\t"+"����״̬"+"\t"+"�ܽ��");
					    	for (int i=0;i<names.length;i++){
					    		if (names[i]!=null){
					    			String state=states[i]==0?"��Ԥ��":"��ǩ��";
					    			String date=times[i]+"��";
					    			String sumPrice=sumPrices[i]+"Ԫ";
					    			System.out.println(lines[i]+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+date+"\t"
					    						+addresses[i]+"\t"+state+"\t"+sumPrice);
					    			
					    			if(states[i]==0){         //δǩ�ն���
						    			number++;
						    		}
					    		}
					    	}
					    	//û����ǩ�ն���
					    	if(number==0){
					    		System.out.println("��δǩ�ն�����Ϣ��");
			    				break;
					    	}
					    	
					    	//ǩ�ն���:
					    	for(int i=0;i<names.length;i++){       //�����������Ϊ���鳤��
					    		System.out.println("��ѡ����Ҫǩ�յĶ�����ţ�");
					    		if (input.hasNextInt()==true){
					    			number = input.nextInt();
					    			if (number>0 && number<=names.length){    //�����±귶Χ
					    				if(names[number-1]==null){          //������Ϊ��
					    					System.out.println("��ѡ��Ķ��������ڣ�");
					    				}else if(states[number-1]==0){        //״̬Ϊδǩ��
						    				System.out.println("ǩ�ճɹ���");
											states[number-1]=1;
											break;
										}else {                             //����Ϊ��
											System.out.println("�ö�������ǩ�գ��޷��ٴ�ǩ�գ�");
											break;
									    }
					    			}else{                                //����������ŷ�Χ
								    	System.out.println("��ѡ��Ķ��������ڣ�");
								    }
					    		}else{               //���벻Ϊ����
									System.out.println("����ȷ���룺");
									input.next();
									continue;
								}
					    	}
					    	no=1;  //�˳���һѭ��
					    	break;
					    case 4:
					    	System.out.println("****"+str[num-1]+"****");
					    	int numb=0;
					    	/****������Ϣ****/
					    	System.out.println("���"+"\t"+"������"+"\t"+"��Ʒ��Ϣ"+"\t\t"+"�Ͳ�ʱ��"+"\t"+"�Ͳ͵�ַ"+"\t\t"
					    				+"����״̬"+"\t"+"�ܽ��");
					    	for (int i=0;i<names.length;i++){
					    		if (names[i]!=null){
					    			String state=states[i]==0?"��Ԥ��":"��ǩ��";
					    			String date=times[i]+"��";
					    			String sumPrice=sumPrices[i]+"Ԫ";
					    			System.out.println(lines[i]+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+date+"\t"
					    						+addresses[i]+"\t"+state+"\t"+sumPrice);
					    			
					    		}
					    		if(states[i]!=0){         //��ǩ�ն���
					    			numb++;
					    		}
					    		
					    	}
					    	//û����ǩ�ն��������޿�ɾ����Ϣ
					    	if(numb==0){
					    		System.out.println("�޿�ɾ��������Ϣ��");
					    		no=1;  //�˳���һѭ��
			    				break;
					    	}
					    	//ɾ������
					    	for(int j=0;j<names.length;j++){        //�����������Ϊ���鳤��
					    		System.out.println("��ѡ����Ҫɾ���Ķ�����ţ�");
					    		if (input.hasNextInt()==true){
						    		numb = input.nextInt();
						    		if(numb>=1 && numb<=names.length){       //���������±귶Χ
						    			if(names[numb-1]==null  ){        //������Ϊ��
						    				System.out.println("���������ڣ�");
						    			}else if( states[numb-1]!=0){      //������ǩ��
						    				//ɾ����ǰ������������ź󶩵�ǰ��
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
											System.out.println("������ɾ����");
							    			break;
						    			}else{              					 //����Ϊǩ��
						    				System.out.println("������δǩ�գ��޷�ɾ����");
						    				break;
						    			}
						    			
						    		}else{                                  //����������ŷ�Χ
										System.out.println("���������ڣ�");
										
										continue;
									}
						    	}else{
									System.out.println("����ȷ���룺");
									input.next();
									continue;
								}
					    	}
					    	no=1;  //�˳���һѭ��
					    	break;
					    case 5:
					    	System.out.println("****"+str[num-1]+"****");
					    	/****�˵�****/
					    	System.out.println("************************");
							System.out.println("���\t����\t\t����\t������");
							for (int i=0;i<dishNames.length;i++){
								System.out.println(lines[i]+"\t"+dishNames[i]+"\t\t"+prices[i]+"\t"+praiseNum[i]);
							}
							
					    	//����
					    	for(int i=0;i<names.length;i++){      //�����������Ϊ���鳤��
					    		System.out.println("��������Ҫ���޵Ĳ�Ʒ��ţ�");
					    		if(input.hasNextInt()==true){
					    			int number2=input.nextInt();
					    			if(number2>0 && number2<=dishNames.length){
					    				int count1 = 0;     //����
					    				int count2 = 0;     //����
					    				//�жϵ����ʸ��ж��͸ò�Ʒ���Ҷ�����ǩ��,�һ�δ����
					    				for(int j=0;j<names.length;j++){
					    					if(names[j]==null){      //��Ӧ����޶���
					    						continue;
					    					}
					    					String[] s = dishMegs[j].split(" ");    //����Ʒ��Ϣ��ֳɲ�Ʒ������
					    					//�ж��Ƿ�ӵ�е����ʸ�
//					    					System.out.println(dishNames[number2-1]+" ----- "+s[0]+" ------- "+dishMegs[j]);
//					    					System.out.println(dishNames[number2-1].equals(s[0]));
					    					if(dishNames[number2-1].equals(s[0]) && states[j]==1 && isPraise[j]==0){
					    						System.out.println("���޳ɹ���");
							    				praiseNum[number2-1]++;
							    				isPraise[j]=1;
							    				count1++;
							    				break;
					    					}else if(dishNames[number2-1].equals(s[0]) && states[j]==1 && isPraise[j]==1){
					    						//�ö����Ѿ�����
					    						count2++;
					    					}
					    					
					    				}
					    				if(count1!=0){    //�Ѿ�����
					    					break;
					    				}
					    				if(count2>0){      //�����ѵ���
					    					System.out.println("���ѵ��ޣ��޷��ٴε��ޣ�");
					    				}else{
					    					System.out.println("��δ��������δǩ�գ��˲�Ʒ���޷����ޣ�");
					    				}
					    				break;
					    				
					    			}else{
					    				System.out.println("�޴˶��������������룺");
					    				continue;
					    			}
					    		}else{
					    			System.out.println("����ȷ���룺");
									input.next();
									continue;
					    		}
					    		
					    	}
					    	no=1;  //�˳���һѭ��
					    	break;
					    case 6:	
					    	no=1;   //�˳���һѭ��
					    	isExit =true;
					        break;
					    default:
					    	no=0;      //��ǰѭ��������������ǰѭ��
					    	System.out.println("����������������룡");
					    	continue;
					}
					
				
				}else{
					no=0;     //��ǰѭ��������������ǰѭ��
					System.out.println("����������������룡");
					input.next();
				}
				
			}while(no==0);
			
			if (isExit){
				System.out.println("ллʹ�ã���ӭ�´ι��٣�");
				break;
			}
			
			if(!"0".equals(isContinue)){
				System.out.println("����0������һҳ�棬���������˳�ϵͳ��");
				isContinue =input.next();
				if(!"0".equals(isContinue)){
					System.out.println("ллʹ�ã���ӭ�´ι��٣�");
			    	break;
				}
			}
			
		}while(no!=0);
		System.out.println("���������");

	}

}
