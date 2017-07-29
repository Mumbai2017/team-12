from django.http import HttpResponse
from django.shortcuts import render
from MakeAWish.models import ChildProfile, Doctor, Volunteer, Donor, Transaction

# Create your views here.

def index(reqeust):
    return HttpResponse("This is the index page")



