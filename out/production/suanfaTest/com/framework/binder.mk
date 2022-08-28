1.为什么要用多进程？
 一个进程分配的内存大小有限，多进程可以分配更多的内存
 系统资源紧张（OOM)
 应用架构臃肿（webview,推送，后台任务）
 webview 占用系统资源比较多  推送，后台任务功能较为单一

 一些黑科技 (保活）

 注意点；
 application 生命周期 （OnCreate)
 数据共享失效（对象、单例、回调）
 进程间通信（文件、Intent、AIDL)



 跨进程通信（IPC)
  进程间通过内核提供的机制完成数据交换。称之为进程通信（IPC,Inter Process Communication)

  Linux  跨进程通信
  1.管道：
  2.消息队列
  3.信号
  4.共享内存（效率高，需要有同步机制）
  5.信号量
  6.socket(C/S结构跨网络通信）

android跨进程通信核心
   Binder :
      c/s 架构，稳定性好，优于共享内存方式
      性能较好，数据拷贝次数优于管道、消息队列、socket(两次），binder只拷贝一次
      安全性高，UID/PID可见


  AIDL (基于Binder)
  Intent 、Messenger 、ContentProvider(基于AIDL)
  文件共享