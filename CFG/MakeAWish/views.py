from django.http import HttpResponse
from django.shortcuts import render
from MakeAWish.models import ChildProfile, Doctor, Volunteer, Donor, Transaction
from CFG.settings import TEMPLATE_PATH, STATIC_URL


# Create your views here.

def admin_panel(request):
    
    return render(request, TEMPLATE_PATH + '/MakeAWish/index.html')


def wishes_panel(request):
    return render(request, TEMPLATE_PATH + '/MakeAWish/wishes.html')


def volunteer_panel(request):
    return render(request, TEMPLATE_PATH + '/MakeAWish/vol.html')


def doctor_panel(request):
    return render(request, TEMPLATE_PATH + '/MakeAWish/doc.html')


def donoe_panel(request):
    return render(request, TEMPLATE_PATH + '/MakeAWish/donor.html')
