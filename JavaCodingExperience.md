# LeetCode每日一题

## 20221005 字符串转义问题

做题时发现字符串域名在对"."进行分割时需要进行转义"\\\\."，不然分割失败。

csdn别人的链接：https://blog.csdn.net/qq_44099797/article/details/125681911

## 20221006 三等分问题

```java
// 统计二进制数组中1的个数
Arrays.stream(nums).sum();

```















# LeetCode周赛

## 20221009 10:30 第314场

### 2. 前缀和异或

    a ^ 0 = a
    
    0 ^ 1 = 1
    
    a ^ a = 0
    
    a ^ b = b ^ a
    
    因此本题答案就是 :
    
    arr[i] = pref[i] ^ pref[i - 1]
