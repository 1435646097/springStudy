package com.paigu.interview.main;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamMain {
    public static void main(String[] args) {
        //List<Integer> result = IntStream.rangeClosed(0, 1000)
        //                                .filter(i -> i > 200)
        //                                .map(i -> RandomUtil.randomInt(200, 1000))
        //                                .sorted()
        //                                .limit(10)
        //                                .boxed()
        //                                .collect(Collectors.toList());
        //result.stream().count();
        //List<Book> list = new ArrayList<>();
        //log.info(result.toString());
         StreamMain streamMain = new StreamMain();
        streamMain.showShortName();
    }

    public void showShortName(){
        String shortName = this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".")+1);
        System.out.println(shortName);
        shortName = this.getClass().getSimpleName();
        System.out.println(shortName);
    }
}
