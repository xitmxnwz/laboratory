package laboratory;

import java.util.ArrayList;
import java.util.List;

class MyObject{
    //设置默认数组长度为99999更快的发生OutOfMemoryError
    List<String> list = new ArrayList<>(99999);
}

