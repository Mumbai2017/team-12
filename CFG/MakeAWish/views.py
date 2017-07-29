from django.http import HttpResponse
from django.shortcuts import render
from MakeAWish.models import ChildProfile, Doctor, Volunteer, Donor, Transaction
from CFG.settings import TEMPLATE_PATH, STATIC_URL

# Create your views here.

def admin_panel(request):
    print(STATIC_URL)
    return render(request, TEMPLATE_PATH + '/MakeAWish/index.html')
