# RestSalesForecast

Restaurant sales analysis and forecast

## 1. 选题背景

本次比赛，我选择了17个Global Goals中的第12个主题，负责任的消费和生产。

现如今科技发展十分迅速，近几年来人工智能技术在社会生活中的应用也越来越广泛。人工智能创新将成为实现联合国可持续发展目标（SDG）的核心，并有助于解决人类面临的巨大挑战。

例如，机器学习和推理可以通过自动诊断和有效利用有限的医疗专业知识和运输资源（SDG3）将医疗保健扩展到偏远地区，人工智能还将成为遏制城市环境温室气体排放和支持智慧城市发展的关键资源（可持续发展目标11和13），而全球伙伴关系（可持续发展目标17）将为我们实现所有这些目标提供重要支持。

对于第12个可持续发展目标，重点在于确保可持续的消费和生产模式。在该领域，目前人工智能正在通过垂直绿色农场产生最佳消费和生产水平，消除浪费并大大提高产量和资源效率。

而本项目原型是想要通过对餐厅经营过程中积累的数据进行分析建模，实现短期的消费预测，从而帮助餐厅合理备货，减少库存浪费。

这与以下两个子目标契合：
12.3 - 减少全球人均食物浪费
12.5 - 大幅减少废物生产

通过销售分析和预测，一方面餐厅能够更加合理地售卖客人喜欢的菜品，减少不必要的浪费，另一方面也能从源头上优化餐饮供给与生产配比。

## 2. 项目原型说明

### 2.1 目录结构说明

- analysis: 数据分析与预测的实现代码
- visual: 数据可视化代码
- demo: 暂存的网页样例（供环境配置前预览）
- war: 用于发布网站的war包

### 2.2 网站运行环境说明

本原型通过网站展示数据分析与预测结果。

#### 软件开发环境

- Java JDK1.8.0_144
- apache-tomcat-8.5.6  
- SQL Server 2008 R2  
- IntelliJ IDEA  

#### 代码运行说明  

1. 请安装SQLServer2008R2，将数据库还原，由于数据库备份文件较大，所以请到百度云盘下载  
  链接：https://pan.baidu.com/s/1V70U7rXemMcrF-5zvKG4Ag 密码：j9tc
2. 请安装相应的JDK、部署tomcat，安装IDEA，配置工程运行，注意修改数据库配置文件中的用户名与密码  
3. 或者直接将war目录下的rest-sales-analysis.war放到tomcat的webapps目录下，启动tomcat即可通过http://localhost:8080/rest-sales-analysis访问网站，注意也需要修改数据库配置文件  


## 2.3 数据分析预测代码说明

#### 编程语言及运行环境  

- Python  

#### 目录说明  

- data目录存放原始数据
- 生成result目录存放预测结果

## 代码运行说明
sudo pip install numpy  
sudo sudo apt-get install python-matplotlib ipython ipython-notebook  
sudo apt-get install python-pandas python-sympy python-nose  
sudo pip install scipy  
sudo pip install scikit-learn 

python proc.py  

- 聚类和回归算法调用了sklearn.  
- spark版本使用了mllib


