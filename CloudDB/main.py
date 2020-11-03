import firebase_admin
from firebase_admin import credentials
from firebase_admin import firestore

# Use the application default credentials
cred = credentials.Certificate('CloudDB/Service_account_key.json')
firebase_admin.initialize_app(cred)
db = firestore.client()
#print(db)
# results = db.collection("Payment_Info").get()

# for result in results:
#     info = result.to_dict()
#     print(info)

def ask():
    choice = None
    while choice != "3":
        print()
        print("1) Create User ")
        print("2) Edit User/Payment/Wish list info")
        print("3) Quit")
        choice = input("> ")
                if choice == "1":
                   createUser()
                elif choice == "2":
                    userInfo()
                else:
                    print("Goodbye!")

def userInfo():
    choice = None
    while choice != 5:
        print()
        print("1) Edit User Info")
        print("2) Edit Payment Info")
        print("3) Edit Wish List")
        print("4) Edit Address")
        print("5) Quit")
        choice = input("> ")
            if choice == "1":
                updateUser()
            elif choice == "2":
                editPay()
            elif choice == "3":
                editList()
            elif choice == "4":
                editAddress()
            else:
                print("Goodbye!")


def createUser():
    user_name = input("Create Username: ")
    password = input("Create password: ")
    first_name = input("Enter First Name: ")
    last_name = input("Enter Last Name: ")
    email = input("Enter Email: ")
    number = input("Enter Phone Number: ")
    values = {"user_name" : user_name, "password" : password, "first_name" : first_name, "last_name" : last_name, "email" : email, "phone_number" : number}
    createUser = db.collection("Users").document(user_name)
    createUser.set(values)
    print("User created Succesfully! Remember to edit payment and wishlist info.")

def updateUser():
    user_name = input("Create Username: ")
    password = input("Create password: ")
    first_name = input("Enter First Name: ")
    last_name = input("Enter Last Name: ")
    email = input("Enter Email: ")
    number = input("Enter Phone Number: ")
    values = {"user_name" : user_name, "password" : password, "first_name" : first_name, "last_name" : last_name, "email" : email, "phone_number" : number}
    updateUser = db.collection("Users").document()
    updateUser.set(values)
    print("User info successfully edited.")

def editPay():
    card = input("Enter Card Number: ")
    exp_date = input("Enter Expiration Date: ")
    CVV = input("Enter CVV: ")
    values = {"card_number" : card, "exp_date" : exp_date, "CVV" : CVV}
    editPay = db.collection("Users").document().collection("payment_info")
    editPay.set(values)
    print("Payment info succesfully edited.")

def editList():


def editAddress():
    address = input("Create Address: ")
    city = input("Create City: ")
    state = input("Enter State: ")
    country = input("Enter Country: ")
    zip_code = input("Enter Zip Code: ")
    values = {"address" : address, "city" : city, "state" : state, "country" : country, "zip_code" : zip_code}
    editAddress = db.collection("Users").document().collection("address")
    editAddress.set(values)
    print("Address successfully edited.")



def main():

    print("User Database\n")
    ask()
    
