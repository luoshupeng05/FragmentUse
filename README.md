# FragmentUse
以下内容说明参考来源自：原文链接：https://blog.csdn.net/harvic880925/article/details/44927375

Fragment的基本用法演示。
FragmentTransaction事务回滚使用方法。

在transaction.commit()之前，使用addToBackStack()将其添加到回退栈中。
transaction.addToBackStack(String tag);

主要方法：
void popBackStack(int id, int flags);
void popBackStack(String name, int flags);

参数int id是当提交变更时transaction.commit()的返回值。

参数string name是transaction.addToBackStack(String tag)中的tag值；

至于int flags有两个取值：0或FragmentManager.POP_BACK_STACK_INCLUSIVE；

当取值0时，表示除了参数一指定这一层之上的所有层都退出栈，指定的这一层为栈顶层； 

当取值POP_BACK_STACK_INCLUSIVE时，表示连着参数一指定的这一层一起退出栈； 


演示过程：

1、逐个将Fragment1,2,3,4添加到窗口中，在添加时，每添加一个Fragment要利用transaction的addToBackStack将此次操作加入到回退栈中。

2、然后点击"PopBackStack"方法，将栈顶最上层的操作回退。退将最后一次添加回退出来，显示Fragment3.

3、点击“ADD Fragment4”将栈还原到1，2，3，4依次ADD进栈的状态，即操作1完成后的栈状态，然后点击“BackToStack2_0”，其实调用的方法是：

   manager.popBackStack("fragment2",0);//方法一,通过TAG回退
   
   回退到添加ADD Fragment2的状态，最后一个参数设为0，表明，要回退ADD Fragment2的之后的操作，将Fragment2的操作置为栈顶。
   
4、最后仍然是先点击"Add Fragment3"和"ADD Fragment4"，将栈还原到操作1完成后的栈状态。然后点击“BackToStack2_INCLUSIVE”;其调用的方法是：

   manager.popBackStack("fragment2",FragmentManager.POP_BACK_STACK_INCLUSIVE);//方法一,通过TAG回退
   
   ==============================第二次提交==========================================
   
  
  1、更新intent-filter的使用练习
  2、ViewBinding练习
  3、关于ViewBinding
  
 * 视图绑定的使用（ViewBinding）
 * 1、调用生成的绑定类中包含的静态 inflate() 方法。此操作会创建该绑定类的实例以供 Activity 使用。
 * 
 * 2、通过调用 getRoot() 方法或使用 Kotlin 属性语法获取对根视图的引用。
 * 
 * 3、将根视图传递到 setContentView()，使其成为屏幕上的活动视图。
 

  
   

   
