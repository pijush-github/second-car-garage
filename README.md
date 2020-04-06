# second-car-garage

Technology stack
 - Spring boot
 - Angular
 - Embeded MongoDB
 
 Requirements:
 
 ###### Background
So, I have a friend called Frank. He owns a second hand car garage and needs your help!
He would like you to create a website for his shop. These days Frank only sells his second hand cars online and could use a website of his own. With that said I guess we should do this in phases, because you know...agile! So it would be best if you start with **phase 1**!

 

###### Phase 1:
Start by creating a page that will display all of the cars that Frank has across all of his warehouses. Please sort the list according to _date_added_ asc. Below you will find a section with some sample data that you can use as for you application.
###### Phase 2:
Now, allowing the user to click on any of the cars (that are licensed = true) would make it a lot nicer. Once the user clicked on a car, we then show more details such as, the warehouse where it is stored and its location perhaps? It is up to you how detailed you want to make it.
###### Phase 3:
Wow! Okay, we now have some good functionality! So lets take it one step further! Lets allow the user to add the car he is viewing to some sort of shopping cart so that he can easily checkout once he is done shopping. Oh, and perhaps we should show the user the total amount as well?

Sample Data :

[
        {

          "_id": "1",

          "name": "Warehouse A",

          "location": {

            "lat": "47.13111",

            "long": "-61.54801"

          },

          "cars": {

            "location": "West wing",

            "vehicles": [

              {

                "_id": 1,

                "make": "Volkswagen",

                "model": "Jetta III",

                "year_model": 1995,

                "price": 12947.52,

                "licensed": true,

                "date_added": "2018-09-18"

              },

              {

                "_id": 2,

                "make": "Chevrolet",

                "model": "Corvette",

                "year_model": 2004,

                "price": 20019.64,

                "licensed": true,

                "date_added": "2018-01-27"

              },

              {

                "_id": 3,

                "make": "Ford",

                "model": "Expedition EL",

                "year_model": 2008,

                "price": 27323.42,

                "licensed": false,

                "date_added": "2018-07-03"

              }

            ]

          }

        },

        {

          "_id": "2",

          "name": "Warehouse B",

          "location": {

            "lat": "15.95386",

            "long": "7.06246"

          },

          "cars": {

            "location": "East wing",

            "vehicles": [

              {

                "_id": 4,

                "make": "Maserati",

                "model": "Coupe",

                "year_model": 2005,

                "price": 19957.71,

                "licensed": false,

                "date_added": "2017-11-14"

              },

              {

                "_id": 5,

                "make": "Isuzu",

                "model": "Rodeo",

                "year_model": 1998,

                "price": 6303.99,

                "licensed": false,

                "date_added": "2017-12-03"

              },

              {

                "_id": 6,

                "make": "Infiniti",

                "model": "I",

                "year_model": 2002,

                "price": 6910.16,

                "licensed": false,

                "date_added": "2017-10-15"

              }

            ]

          }

        },

        {

          "_id": "3",

          "name": "Warehouse C",

          "location": {

            "lat": "39.12788",

            "long": "-2.71398"

          },

          "cars": {

            "location": "Suid wing",

            "vehicles": [

              {

                "_id": 7,

                "make": "Cadillac",

                "model": "Escalade",

                "year_model": 2005,

                "price": 7429.18,

                "licensed": true,

                "date_added": "2018-09-26"

              },

              {

                "_id": 8,

                "make": "Porsche",

                "model": "Cayenne",

                "year_model": 2011,

                "price": 17066.31,

                "licensed": true,

                "date_added": "2017-10-19"

              },

              {

                "_id": 9,

                "make": "Mercedes-Benz",

                "model": "SL-Class",

                "year_model": 2005,

                "price": 14066.06,

                "licensed": false,

                "date_added": "2018-08-08"

              }

            ]

          }

        },

        {

          "_id": "4",

          "name": "Warehouse D",

          "location": {

            "lat": "-70.84354",

            "long": "132.22345"

          },

          "cars": {

            "location": "Nord wing",

            "vehicles": [

              {

                "_id": 10,

                "make": "Saab",

                "model": "900",

                "year_model": 1987,

                "price": 8771.0,

                "licensed": false,

                "date_added": "2017-12-01"

              },

              {

                "_id": 11,

                "make": "Mazda",

                "model": "B-Series",

                "year_model": 1998,

                "price": 23407.59,

                "licensed": false,

                "date_added": "2018-03-01"

              },

              {

                "_id": 12,

                "make": "GMC",

                "model": "Sierra 3500",

                "year_model": 2012,

                "price": 5869.23,

                "licensed": true,

                "date_added": "2018-04-27"

              }

            ]

          }

        }

      ]
 
 
 Running the application locally:
 
mvnw clean package spring-boot:repackage
 
mvnw spring-boot:run
