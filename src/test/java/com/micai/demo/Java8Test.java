package com.micai.demo;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.security.auth.x500.X500Principal;

import org.apache.el.stream.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.micai.demo.entity.Person;
import com.micai.demo.java8.BeanFactory;
import com.micai.demo.java8.BootStrapInterface1;
import com.micai.demo.java8.BootStrapTest;
import com.micai.demo.java8.IConvert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Java8Test {

	/** {@link HashMap}的性能提升：测试结果:http://www.importnew.com/14417.html */
	@Test
	public void test1() {
		Map<String, String> map = new HashMap<>();
		map.put("1", "001");
		map.put("2", "002");
		System.out.println(map);
	}

	@Test
	public void test01(){
		List<Integer> list = new ArrayList<>();
		list.add(23);
		list.add(34);
		list.add(31);
		list.add(23);
		//1.遍历
		list.forEach(c->{
			System.out.println(c);
		});
		//2.判断打印和存放集合
		list.stream().filter(c->c>30).forEach(System.out::print);
		System.out.println("判断=" +list.stream().filter(c->c==30).collect(Collectors.toList()));

		//3.取值
		System.out.println("最小值=" + list.stream().mapToInt(c->c).min().getAsInt());
		System.out.println("平均值=" + list.stream().mapToInt(c->c).average().getAsDouble());
		System.out.println("和值=" + list.stream().mapToInt(c->c).sum());
		//4.集合
		List list2 = list.stream().filter(c->c>30).collect(Collectors.toList());
		System.out.println("集合=" + list2);
		//
		
	}
	/** 接口默认方法
	 * 优势：扩展接口，不用每个子类都实现，子类可通过重写选择使用哪一个。 */
	@Test
	public void test2() {
		BootStrapTest test1 = new BootStrapTest();
		int result1 = test1.add(1, 2);
		System.out.println("java8-> absSub(): " + result1);
	}

	/** 静态方法 
	 * 优势：增加了和类的静态方法调用一致。*/
	@Test
	public void test3() {
		double result1 = BootStrapInterface1.div(4, 2);
		System.out.println("java8-> 静态方法: " + result1);
	}

	/** {@link LocalDateTime} */
	@Test
	public void test4() {
		// new
		System.out.println("java8-> 当前日期(new)：" + LocalDateTime.now());

		// old
		System.out.println("java8-> 当前日期(old)：" + new Date());
	}

	/** {@link LocalDate} */
	@Test
	public void test5() {
		LocalDate now = LocalDate.now();
		System.out.println("java8-> 当前日期(new)：" + now);

		// 指定日期（new）
		LocalDate diyDate = LocalDate.of(2018, Month.APRIL, 20);
//		LocalDate.parse("20180420",DateTimeFormatter.BASIC_ISO_DATE)
		System.out.println("java8->自定义日期(new)：" + diyDate);

		// 指定时期 (old)
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 3, 20);
		Date date = cal.getTime();
		System.out.println("java8->自定义日期(old0)：" + date);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateToStr = format.format(date);
		System.out.println("java8->自定义日期(old)：" + dateToStr);
	}

	/** {@link LocalTime} */
	@Test
	public void test6() {
		LocalTime time = LocalTime.now();
		System.out.println("java8-> 获取当前时间：" + time);

		// 指定时间(new)
		LocalTime diyTime = LocalTime.of(23, 59, 59);
		System.out.println("java8-> 自定义时间(new)：" + diyTime);

		// 指定时间(old)
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2018, 11, 12, 23, 59, 59);
		String diyTimeOld = cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":"
				+ cal.get(Calendar.SECOND);
		System.out.println("java8-> 自定义时间(old)：" + diyTimeOld);
	}

	/** {@link Instant} */
	@Test
	public void test7() {
		Instant timestamp = Instant.now();
		timestamp.atOffset(ZoneOffset.ofHours(8));//东8区时间+8
		ZonedDateTime zoneDateTime = timestamp.atZone(ZoneId.systemDefault());
		System.out.println("java8-> 瞬时时间：" + timestamp);
		System.out.println("java8-> 瞬时时间：" + zoneDateTime);
	}

	/** {@link Duration} */
	@Test
	public void test8() {
		Duration thirtyDay = Duration.ofDays(30);
		System.out.println("java8-> 持续时间：" + thirtyDay);
	}

	/** {@link DateTimerFormatter} */
	@Test
	public void test9() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
		LocalDateTime timePointer = LocalDateTime.now();
		String temp = formatter.format(timePointer);
		System.out.println("java8-> 格式化：" + temp);
	}

	/** 日期处理 */
	@Test
	public void test10() {
		// leap year
		LocalDate datePoint = LocalDate.now();
		System.out.println("java8-> 是否是闰年:" + datePoint.isLeapYear());
		// 增 年/月/日
		LocalDate addResult = datePoint.plusDays(10);
		System.out.println("java8-> 增加10天" + addResult);
		// 获取一周之后的日期
		System.out.println(datePoint.plus(1, ChronoUnit.WEEKS));

		// 减 年/月/日
		LocalDate minusResult = datePoint.minusYears(1);
		System.out.println("java8-> 减少1年：" + minusResult);

		// old
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, 10);
		System.out.println("java8-> 增加10天 (old) ：" + cal.getTime());
	}

	/** 检查两个日期是否相等 */
	@Test
	public void test11() {
		LocalDate diyDate = LocalDate.of(2018, 11, 12);
		if (diyDate.equals(LocalDate.now()))
			System.out.println("比较日期是否相等: yes");
		else
			System.out.println("no");
	}

	/** 日期兼容 */
	@Test
	public void test12() {
		Date now = new Date();
		Instant instant = now.toInstant();
		LocalDateTime dateTimePoint = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		System.out.println("java8-> 日期兼容：" + dateTimePoint);
	}

	/** 匿名内部类与Lambda表达式 */
	@Test
	public void test14() {

		int a = 1;
		Person p = new Person("Leon", "Sun");
		new IConvert<Integer, String>() {
			@Override
			public Integer convert(String from) {
				p.setFirstName("liming");
				System.out.println(p.getFirstName());
				return Integer.valueOf(from);
			}
		}.convert("123");
	}

	@Test
	public void test15() {
		Person p = new Person("Leon", "Sun");
		IConvert<Integer, String> c = x -> {
			p.setLastName("lll");
			return Integer.valueOf(x);
		};
		c.convert("123");
	}

	/** Lambda表达式与函数式编程 {@link Function} */
	@Test
	public void test16() {
		Function<String, Integer> func = x -> Integer.valueOf(x);
		int result = func.apply("123");
		System.out.println("function: " + result);
	}

	/** {@link Supplier} */
	@Test
	public void test17() {
		Person p = BeanFactory.getInstance(Person::new);
		p.setFirstName("Jin");
		p.setLastName("SanPang");
		System.out.println(p.toString());
	}

	/** 方法引用和构造函数的引用 https://blog.csdn.net/Tracycater/article/details/75212399 */

	/** {@link Consumer} */
	@Test
	public void test18() {
		Person p = new Person("jin", "sanpang");
		Consumer<Person> consumer = x -> {x.setFirstName("Wang");};
		consumer.accept(p);
		System.out.println(p.toString());
	}

	/** {@link Predicate} */
	@Test
	public void test19() {
		Predicate<Person> condition1 = x -> x.getFirstName().length() < 2;

		Person p = new Person("jin", "sanpang");
		System.out.println(condition1.test(p));
		
		// 多条件判断

		// 实战:统一判断空指针异常
	}
	
	
	
	/** Stream API */
	/** 遍历筛选出年龄大于60岁的人 */
	@Test
	public void test20() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Li", "Ming", 69));
		people.add(new Person("Zhang", "San", 25));
		people.add(new Person("Wang", "Wu", 6));
		// 传统操作
		for (Person person : people) {
			if (person.getAge() > 60) {
				System.out.println("传统操作:"+person.toString());
			}
		}
		// Stream
		people.stream()
			.filter(x->x.getAge()>60) // 中间方法
			.forEach(System.out::println); // 终端方法
	}
	
	/** 串行流/ 并行流 */
	@Test
	public void test21() {
		IntStream intStream = new Random().ints(0, 10000);
		List<Integer> randomNumbers = intStream.limit(1_000_000_0).boxed().collect(Collectors.toList());
		long start = System.nanoTime();
		randomNumbers.stream().sorted();
		long end   = System.nanoTime();
		System.out.println(end - start);
	}
	
	/** 将数组/集合转换为流 */
	@Test
	public void test22() {
		Person[] people = new Person[] {new Person("Li", "Ming", 69),new Person("Zhang", "San", 25)};
		Stream<Person> stream = Stream.of(people); // 方式一
		Arrays.stream(people); // 方式二
	}
	
	/** 聚合操作 求年龄总和/年龄平均值 */
	@Test
	public void test23() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Li", "Ming", 69));
		people.add(new Person("Zhang", "San", 25));
		people.add(new Person("Wang", "Wu", 6));
		
		int sum = people.stream().mapToInt(x->x.getAge()).sum();
		System.out.println("求和:"+sum);
		
		OptionalDouble optionalDouble = people.stream().mapToDouble(x->x.getAge()).average();
		double avg = optionalDouble.getAsDouble();
		System.out.println("平均值:"+avg);
	}
	
	@Test
	public void test100() {
		Clock.systemDefaultZone().millis();
		System.out.println(Clock.systemDefaultZone().millis());
	}
	
}
