##MagicLine
>该项目受[此文](http://mp.weixin.qq.com/s/FieNhelCar1cZjhBS28ymQ)启发。
通过两个点根据一定规律的运动绘制直线，从而画出神奇的视觉效果。

**重要说明**
>最初是看[winjay](https://github.com/wingjay)同学的博客知道的这个创意，且他和[android-cjj](https://github.com/android-cjj)在
[winjay的项目](https://github.com/wingjay/WJMagicCurveView)中已经各自实现了一套，原理都是一样的。这个项目是之前我练手实践是写的，由于
觉得创意实在很棒,所以现在也把它放到我的github上，希望更多的童鞋能够知道。
如果你要看wingjay和android-cjj的实现，请点击上面内容中的链接即可。

**效果**

动图示例(如加载慢请稍等)：

![](https://github.com/zhangyuChen1991/some_sources/blob/master/magicline/draw1-1.gif)

![](https://github.com/zhangyuChen1991/some_sources/blob/master/magicline/draw5-1.gif)

![](https://github.com/zhangyuChen1991/some_sources/blob/master/magicline/draw9_1.gif)

更多绘制效果：

![](https://github.com/zhangyuChen1991/some_sources/blob/master/magicline/ml1.png)
![](https://github.com/zhangyuChen1991/some_sources/blob/master/magicline/ml2.png)

![](https://github.com/zhangyuChen1991/some_sources/blob/master/magicline/ml3.png)
![](https://github.com/zhangyuChen1991/some_sources/blob/master/magicline/ml4.png)

![](https://github.com/zhangyuChen1991/some_sources/blob/master/magicline/ml5.png)
![](https://github.com/zhangyuChen1991/some_sources/blob/master/magicline/ml6.png)

![](https://github.com/zhangyuChen1991/some_sources/blob/master/magicline/ml7.png)
![](https://github.com/zhangyuChen1991/some_sources/blob/master/magicline/ml8.png)

![](https://github.com/zhangyuChen1991/some_sources/blob/master/magicline/ml9.png)
![](https://github.com/zhangyuChen1991/some_sources/blob/master/magicline/ml10.png)

是不是很神奇?
(PS：大家可以自行添加色彩渲染组合出更绚丽的效果，自行发挥哦！)

**关于原理**
>这是一个极其简洁却又极富创意的规则。图形是由两个做圆周运动的点相连而成的，区别仅仅是圆的半径大小以及运行速度。
当我们改变这几个参数，就会发生各种有趣的变化。如果我们把这两个点分别命名为点A和点B
那这几个参数分别是：
>* A的运动角速度
>* B的运动角速度
>* A的X轴运动半径
>* B的X轴运动半径
>* A的Y轴运动半径
>* B的Y轴运动半径
>
>我们把这几个参数设置不同的值，根据运动规律，它们便会画出不同的图案，效果你想都想不到哦！

**关于实现**
>基础原理都在以上那篇文章里(忍不住再为作者极具创造性和启发性的想法点个赞)
在Android上实现了一个自定义view：MagicLineView，大家有兴趣可以把项目下载看，代码量很少。

最后感谢大家的光临，谢谢你的支持哦！