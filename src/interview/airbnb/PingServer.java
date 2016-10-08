package interview.airbnb;

/**
3） 写echo TCP client， 向面试官的server发请求， 读回数据。地里比较少人说这种， 我来详细说一下， 情境是这样的： 想象你开车， 踩下油门，车会加速，放开油门，车会减速。 client向server发的请求有以下2种： （a）STATUS –表示查询现在车的速度和踩下踏板的压力； （b）THROTTLE 50.1 — 这条指令是“THROTTLE” 加上一个数字， 表示我现在将踩油门的压力调为50.1

EXAMPLE: 比如在telnet中
STATUS
0.0 0.0 (这行是server返回的， 第一个数字表示压力，第二个数字表示速度)
THROTTLE 50.1 (这个指令发出 server没有返回)
STATUS
50.1 3.75 (可以看到速度在缓慢上升)
STATUS (过几秒后，你又发STATUS指令过去)
50.1 15.98 (速度依旧上升。。。)

对就是这样，像是简单物理实验。

写完TCP client后，要求是写一个方法将速度控制到达一个target speed

最后一个问题是求这个 delta力 和 delta速度 之间的函数关系。。。。。。。。醉了。我物理还给老师了。。。。。。时间不够了*/

public class PingServer
{

	public PingServer( )
	{
	}

}
