import firebase_admin
from firebase_admin import credentials
from firebase_admin import firestore
import os
import random

# Use the application default credentials
cred = credentials.Certificate('./Service_account_key.json')
firebase_admin.initialize_app(cred)
db = firestore.client()
return db