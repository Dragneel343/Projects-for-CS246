import firebase_admin
from firebase_admin import credentials
from firebase_admin import firestore

# Use the application default credentials
cred = credentials.Certificate('CloudDB/Service_account_key.json')
firebase_admin.initialize_app(cred)
db = firestore.client()
#print(db)
# results = db.collection("users").get()

# for result in results:
#     info = result.to_dict()
#     print(info['Name'])

