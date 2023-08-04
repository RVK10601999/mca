/* insert into customer
(c_no,c_name,city)
values
(40000,'Vicky','Chennai'),
(40001,'Swathi','Trivandrum'),
(40002,'Hema','Pune'),
(40003,'Ragini','Bangalore'),
(40004,'Jojin','Coimbatore'),
(40005,'Aravind','Salem')
; */

###CREATE#####
db.coll.insertMany([{"c_no":40000,"c_name":"Vicky","city":"Chennai"},{"c_no":40001,"c_name":"Swathi","city":"Trivandrum"},{"c_no":40002,"c_name":"Hema","city":"Pune"},
{"c_no":40003,"c_name":"Ragini","city":"Chennai"},{"c_no":40004,"c_name":"Jojin","city":"Trivandrum"},{"c_no":40005,"c_name":"Aravind","city":"Salem"}])



###READ#####
db.coll.find({c_name: "Jojin"})

/*AND*/
db.coll.find({$or:[{c_name:"Jojin"},{c_name:"Vicky"}]}).distinct("c_name")

#>
db.coll.find({"c_no":{$gt:40000}});
#>=
db.coll.find({"c_no":{$gte:40000}});

#<
db.coll.find({"c_no":{$lt:40004}});
#<=
db.coll.find({"c_no":{$lte:40004}});


db.stats_table.insertMany([{
	"name":"Invincible","power":3.89,"age":16
},{
	"name":"Omni-Man","power":4.21,"age":48
},{
	"name":"Immortal","power":3.75,"age":5000000000
}])


db.stats_table.find({"age":{$gte:100}});
###UPDATE#####

db.stats_table.updateOne({"name":"Immortal"},{$set:{"age":40}});

db.stats_table.updateMany({"name":"Immortal"},{$set:{"age":40}});

db.stats_table.find({"age":{$gte:30}});

###DELETE#####
db.coll.deleteOne({"city":"Chennai"});
db.coll.deleteMany({"city":"Chennai"});


####DROP#####
db.coll.drop()
