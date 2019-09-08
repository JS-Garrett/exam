package org.hnjk.jaxb.util;

import java.util.HashSet;
import java.util.Set;


/**
 * @ClassName: SectionUtil 
 * @Description: 区间的工具类 
 * @author ywx 
 * @date 2015-7-3 上午10:54:45
 */
public class DateTimeSectionUtil {
	/**
	 * @Title: getFinalSection 
	* @Description: 获取最终的区间
	 * @param @param originalSet,元素的规则为：开始时间点-结束时间点
	 * @param @param interval 间隔，即两个区间之间允许的误差值
	 * @param @return 设定文件 
	 * @return Set<String> 返回类型 
	 * @throws
	 */
	public static Set<String> getFinalSection(Set<String> originalSet,double interval){
		//时间点的集合
		Set<String> pointSet = new HashSet<String>();
		//新的时间点集合
		Set<String> newPointSet = new HashSet<String>();
		//是否需要继续递归
		boolean needContinue = false;
		//需要删除的数据
		Set<String> deleteSet = new HashSet<String>();
		
		for(String dataStr:originalSet){
			String[] dataArr = dataStr.split("-");
			if(dataArr!=null && dataArr.length==2){
				String startPoint = dataArr[0];
				int startPointInt = 0;
				if(startPoint!=null && !startPoint.equals("")){
					startPointInt = Integer.parseInt(startPoint);
				}
				String endPoint = dataArr[1];
				int endPointInt = 0;
				if(endPoint!=null && !endPoint.equals("")){
					endPointInt = Integer.parseInt(endPoint);
				}
				
				if(pointSet.size()==0){
					pointSet.add(startPointInt+"-"+endPointInt);
					continue;
				}
				for(String point:pointSet){
					
					String[] pointArr = point.split("-");
					if(pointArr!=null && pointArr.length==2){
						String startPointTmp = pointArr[0];
						int startPointIntTmp = 0;
						if(startPointTmp!=null && !startPointTmp.equals("")){
							startPointIntTmp = Integer.parseInt(startPointTmp);
						}
						String endPointTmp = pointArr[1];
						int endPointIntTmp = 0;
						if(endPointTmp!=null && !endPointTmp.equals("")){
							endPointIntTmp = Integer.parseInt(endPointTmp);
						}
						//1.开始时间点在范围左边，结束时间点在范围左边
						if(endPointInt<startPointIntTmp
								&& endPointInt<startPointIntTmp){
							//在误差允许的范围之内合并两个区间
							if(0<=endPointInt+interval-startPointIntTmp){
								newPointSet.add(startPointInt+"-"+endPointIntTmp);
								deleteSet.add(startPointInt+"-"+endPointInt);
								deleteSet.add(startPointIntTmp+"-"+endPointIntTmp);
							}
							else{
								newPointSet.add(point);
								newPointSet.add(startPointInt+"-"+endPointInt);
							}
							
						}
						//2.开始时间点在范围左边，结束时间点在范围中间
						else if(startPointInt<startPointIntTmp
								&& endPointInt>=startPointIntTmp
								&& endPointInt<=endPointIntTmp){
							newPointSet.add(startPointInt+"-"+endPointIntTmp);
							if(endPointInt!=endPointIntTmp){
								deleteSet.add(startPointInt+"-"+endPointInt);
							}
							deleteSet.add(startPointIntTmp+"-"+endPointIntTmp);
							needContinue = true;
						}
						//3.开始时间点在范围左边，结束时间点在范围右边
						else if(startPointInt<startPointIntTmp
								&& endPointInt>endPointIntTmp){
							newPointSet.add(startPointInt+"-"+endPointInt);
							deleteSet.add(startPointIntTmp+"-"+endPointIntTmp);
							needContinue = true;
						}
						//4.开始时间点在范围中间，结束时间点在范围中间
						else if(startPointInt>=startPointIntTmp
								&& startPointInt<=endPointIntTmp
								&& endPointInt>=startPointIntTmp
								&& endPointInt<=endPointIntTmp){
							newPointSet.add(point);
							if(startPointInt!=startPointIntTmp || endPointInt!=endPointIntTmp){
								deleteSet.add(startPointInt+"-"+endPointInt);
							}
							needContinue = true;
						}
						//5.开始时间点在范围中间，结束时间点在范围右边
						else if(startPointInt>=startPointIntTmp
								&& startPointInt<=endPointIntTmp
								&& endPointInt>endPointIntTmp){
							newPointSet.add(startPointIntTmp+"-"+endPointInt);
							if(startPointInt!=startPointIntTmp){
								deleteSet.add(startPointInt+"-"+endPointInt);
							}
							deleteSet.add(startPointIntTmp+"-"+endPointIntTmp);
							needContinue = true;
						}
						//6.开始时间点在范围右边，结束时间点在范围右边
						else if(startPointInt>endPointIntTmp
								&& endPointInt>endPointIntTmp){
							
							//在误差允许的范围之内合并两个区间
							if(0>=startPointInt-interval-startPointIntTmp){
								newPointSet.add(startPointIntTmp+"-"+endPointInt);
								deleteSet.add(startPointInt+"-"+endPointInt);
								deleteSet.add(startPointIntTmp+"-"+endPointIntTmp);
							}
							else{
								newPointSet.add(point);
								newPointSet.add(startPointInt+"-"+endPointInt);
							}
							
						}
					}
				}
				newPointSet.removeAll(deleteSet);
				deleteSet.clear();
				if(newPointSet!=null && newPointSet.size()!=0){
					pointSet.clear();
					pointSet.addAll(newPointSet);
					newPointSet.clear();
				}
				
			}
		}
		if(pointSet.size()>1 && needContinue){
			return getFinalSection(pointSet,interval);
		}
		else{
			return pointSet;
		}
	}
}
