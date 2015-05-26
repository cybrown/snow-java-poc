#binary
* ###access1

	*Example:* 

		 a.property 

* ###access2

	*Example:* 

		 a[0] 

* ###access3

	*Example:* 

		 a.property[0] + ("12" + 3) 

* ###access4

	*Example:* 

		 a[0].property + ("12" + 3) 

* ###binary1

	*Example:* 

		 12 + ("12" + 3) 

* ###binary2

	*Example:* 

		 

#call
* ###call1

	*Example:* 

		 doSomeStuff() 

* ###call2

	*Example:* 

		 fun () {a+3}() 

* ###callWithArgument

	*Example:* 

		 foo(3) 

* ###callWithArgument2

	*Example:* 

		 foo(bar(1+2)) 

* ###callWithArgumentAndFunction

	*Example:* 

		 foo(3) { 1 + 1} 

* ###callWithoutArgumentAndFunction

	*Example:* 

		 foo() { 1 + 1} 

#class
* ###class1

	*Example:* 

		 class Foo {} 

* ###classWithBody

	*Example:* 

		 class Foo { def a: int = 4; def aPlusOne = fun () {a + 1}} 

#definition
* ###definition1

	*Example:* 

		 def a = 3 

* ###definitionWithGeneric

	*Example:* 

		 def a: List<int> = aListFromSomewhere 

* ###definitionWithGeneric2

	*Example:* 

		 def a: List<List<int> > = aListFromSomewhere 

* ###definitionWithType

	*Example:* 

		 def a: int = 3 

#expressionList
* ###expressionList1

	*Example:* 

		 1;2 

* ###expressionList2

	*Example:* 

		 if (1) 2 else 3;def a = 3;1+2;a 

* ###expressionList3

	*Example:* 

		 1;(2,3) 

#function
* ###function1

	*Example:* 

		 fun (){3} 

* ###functionWithArgument

	*Example:* 

		 fun (a){3+a} 

* ###functionWithArgumentAndType

	*Example:* 

		 fun (a:int){3+a} 

* ###functionWithArgumentAndTypeAndReturnType

	*Example:* 

		 fun (a:int): long {3+a} 

#identifier
* ###identifier1

	*Example:* 

		 foo 

#if
* ###if1

	*Example:* 

		 if (a == 1 ) 2 else 3 

* ###if2

	*Example:* 

		 if (a == 1) 2 else if (a == 3) 4 else 5 

* ###if3

	*Example:* 

		 if (a == 1 ) 2 

#literals
* ###integer1

	*Example:* 

		 320 

#primitiveOperation
* ###primitiveOperation

	*Example:* 

		 #add(a, 1) 

* ###primitiveOperation2

	*Example:* 

		 #add(a, #mul(4, e) ) 

* ###primitiveOperation3

	*Example:* 

		 #neg(3) 

#tuple
* ###functionType

	*Example:* 

		 type MyDelegate fun (num: int): string 

* ###functionTypeWithoutArg

	*Example:* 

		 type MyDelegate fun (): string 

* ###tuple1

	*Example:* 

		 (1, 2) 

* ###tuple2

	*Example:* 

		 (a, fun(){}) 

* ###tuple3

	*Example:* 

		 (1, 2, 3) 

* ###tuple4

	*Example:* 

		 ((1, 2), 3) 

* ###tuple5

	*Example:* 

		 (1, (2, 3)) 

#type
* ###arrayOfInt

	*Example:* 

		 def a: int[] = 0 

* ###tupleArrayOfArrayOfType

	*Example:* 

		 type ArrayOfArrayOfStringAndInt (String, int)[][] 

* ###tupleType

	*Example:* 

		 type TwoInts (int, int) 

* ###tupleType2

	*Example:* 

		 type StringAndInt (String, int) 

* ###tupleWithArray

	*Example:* 

		 type ATuple (int, string, string[]) 

* ###typeAsArrayAlias

	*Example:* 

		 type ArrayOfInt Array<int> 

* ###typeAsIntAlias

	*Example:* 

		 type IFoo int 

* ###typeWith1Member

	*Example:* 

		 type IFoo { doSmth(value: int): int;} 

* ###typeWith2Member

	*Example:* 

		 type IFoo { doSmth(value: int): int; doSmthElse(value: int, value2: string): long;} 

* ###typeWithoutMembers

	*Example:* 

		 type IFoo {} 

#unary
* ###multiplePrefix

	*Example:* 

		 !++--i 

* ###multiplePrefixAndPostfix

	*Example:* 

		 !++--i++-- 

* ###unary1

	*Example:* 

		 i++ 

* ###unary2

	*Example:* 

		 i++-- 

* ###unaryWithCall

	*Example:* 

		 object.getValue()[0]++ 

