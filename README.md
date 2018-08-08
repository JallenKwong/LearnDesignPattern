<table>

<tr>
	<td>分类</td>
	<td>模式</td>
	<td>意图</td>
</tr>

<tr>
	<td rowspan=5>创建型模式</td>
	<td><a href='src/main/java/com/lun/designpattern/factory/example2'>工厂模式</a></td>
	<td>定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。</td>
</tr>

<tr>
	<td><a href='src/main/java/com/lun/designpattern/abstractfactory/example2'>抽象工厂模式</a></td>
	<td>提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。</td>
</tr>

<tr>
	<td><a href='src/main/java/com/lun/designpattern/singleton'>单例模式</a></td>
	<td>保证一个类仅有一个实例，并提供一个访问它的全局访问点。</td>
</tr>

<tr>
	<td><a href='src/main/java/com/lun/designpattern/builder'>建造者模式</a></td>
	<td>将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示。</td>
</tr>

<tr>
	<td><a href='src/main/java/com/lun/designpattern/prototype'>原型模式</a></td>
	<td>用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。</td>    
</tr>

<tr>
	<td rowspan=8>结构型模式</td>
	<td><a href='src/main/java/com/lun/designpattern/adapter/example2'>适配器模式</a></td>
	<td>将一个类的接口转换成客户希望的另外一个接口。适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。</td>
</tr>

<tr>
	<td><a href='src/main/java/com/lun/designpattern/bridge'>桥接模式</a></td>
	<td>将抽象部分与实现部分分离，使它们都可以独立的变化。</td>
</tr>

<tr>
	<td><a href='src/main/java/com/lun/designpattern/filter'>!过滤器模式</a></td>
	<td>允许开发人员使用不同的标准来过滤一组对象，通过逻辑运算以解耦的方式把它们连接起来。</td>
</tr>

<tr>
	<td><a href='src/main/java/com/lun/designpattern/composite'>组合模式</a></td>
	<td>将对象组合成树形结构以表示"部分-整体"的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性。</td>
</tr>

<tr>
	<td><a href='src/main/java/com/lun/designpattern/decorator/example2'>装饰器模式</a></td>
	<td>动态地给一个对象添加一些额外的职责。就增加功能来说，装饰器模式相比生成子类更为灵活。</td>
</tr>

<tr>
	<td><a href='src/main/java/com/lun/designpattern/facade/example2'>外观模式</a></td>
	<td>为子系统中的一组接口提供一个一致的界面，外观模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。</td>
</tr>

<tr>
	<td><a href='src/main/java/com/lun/designpattern/flyweight'>享元模式</a></td>
	<td>运用共享技术有效地支持大量细粒度的对象。</td>
</tr>

<tr>
	<td><a href='src/main/java/com/lun/designpattern/proxy'>代理模式</a></td>
	<td>为其他对象提供一种代理以控制对这个对象的访问。</td>
</tr>

<tr>
	<td rowspan=12>行为型模式</td>
	<td><a href='src/main/java/com/lun/designpattern/chainofresponsibility'>责任链模式</a></td>
	<td>避免请求发送者与接收者耦合在一起，让多个对象都有可能接收请求，将这些对象连接成一条链，并且沿着这条链传递请求，直到有对象处理它为止。</td>
</tr>

<tr>
	<td><a href='src/main/java/com/lun/designpattern/command/example2'>命令模式</a></td>
	<td>将一个请求封装成一个对象，从而使您可以用不同的请求对客户进行参数化。</td>
</tr>

<tr>
	<td><a href='src/main/java/com/lun/designpattern/interpreter'>解释器模式</a></td>
	<td>给定一个语言，定义它的文法表示，并定义一个解释器，这个解释器使用该标识来解释语言中的句子。</td>
</tr>

<tr>
	<td><a href='src/main/java/com/lun/designpattern/iterator'>迭代器模式</a></td>
	<td></td>
</tr>

<tr>
	<td><a href='src/main/java/com/lun/designpattern/mediator'>中介者模式</a></td>
	<td>用一个中介对象来封装一系列的对象交互，中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。</td>
</tr>

<tr>
	<td><a href='src/main/java/com/lun/designpattern/memento'>备忘录模式</a></td>
	<td></td>
</tr>

<tr>
	<td><a href='src/main/java/com/lun/designpattern/observer'>观察者模式</a></td>
	<td></td>
</tr>

<tr>
	<td><a href='src/main/java/com/lun/designpattern/state'>状态模式</a></td>
	<td></td>
</tr>

<tr>
	<td><a href='src/main/java/com/lun/designpattern/nullobject'>空对象模式</a></td>
	<td></td>
</tr>

<tr>
	<td><a href='src/main/java/com/lun/designpattern/strategy'>策略模式</a></td>
	<td></td>
</tr>

<tr>
	<td><a href='src/main/java/com/lun/designpattern/templatemethod'>模板模式</a></td>
	<td></td>
</tr>

<tr>
	<td><a href='src/main/java/com/lun/designpattern/visitor'>访问者模式</a></td>
	<td></td>
</tr>

</table>