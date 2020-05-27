use std::string::ToString;
use std::thread;

// 这个函数将创建十个同时并发运行的线程
// 若要验证这一点，可多次运行这个程序，观察各线程输出顺序的随机性
fn main() {
    // 这个字符串是不可变的，因此可以安全地同时被多个线程访问
    let greeting = "Hello";

    let mut threads = Vec::new();
    // `for`循环可用于任何实现了`iterator`特性的类型
    for num in 0..10 {
        threads.push(thread::spawn(move || {
            // `println!` 是一个可以静态检查格式字符串类型的宏
            // Rust的宏是基于结构的（如同Scheme）而不是基于文本的（如同C）
            println!("{} from thread number {}", greeting, num);
        }));
    }

    // 收集所有线程，保证它们在程序退出前全部结束
    for thread in threads {
        thread.join().unwrap();
    }

    let new_thread = thread::spawn(move || {
        println!("I am a new thread");
    });

    new_thread.join().unspaw();

    // 创建一个线程，线程名称为 thread1, 堆栈大小为4k
    let new_thread_result = thread::Builder::new()
        .name("thread1".to_string())
        .stack_size(4 * 1024 * 1024)
        .spawn(move || {
            println!("I am thread1.");
        });
    // 等待新创建的线程执行完成
    new_thread_result.unwrap().join().unwrap();
}
