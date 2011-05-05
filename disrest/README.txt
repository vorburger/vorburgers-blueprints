disrest = Di's REST ;)
	because when I was hacking this Di (rightfully) suggested I rest :) some, thus the ACK.

	
TODO
	flesh out dyn API, impl; get test to pass, complete it

	impl.statcbean, impl.dyn

-

	build REST front-end, use 2-3 REST frameworks..
	
-

	write test.. for all Operations! 
	extend test to assert that 'back-end' is not called when it shouldn't

	is a get-by-id on Resources needed?

	delete(), on Resource
	must be lazy; fetch a "hollow" Book instance (do NOT expose BookId!)
		as it's just an interface there could be an internal impl with only one field (memory!)

-		

	study SDO!  mostly interesting for its change tracking for writing, not so relevant for read-only?

	save() on modifying objects
		in a remoted XML serialized scenario, client will first get() existing then set() fields and then save()
		this cannot cause an unnecessary load() 

	restricting/trimming resource details (e.g. for a column chooser to reduce amount of data)
		incl. API to dynamically overload ReferenceRemotingType (in URL)
	
	LibraryBackEndJPAImpl JPA-based impl example, illustrating how to efficiently impl this for an RDBMS back-end (but it could be any other type of back-end, actually) 
		using Spring JPA?
			useful stuff e.g. https://github.com/SpringSource/spring-data-mapping/blob/master/spring-datastore-web/src/main/groovy/org/springframework/datastore/mapping/web/support/OpenSessionInViewInterceptor.java

